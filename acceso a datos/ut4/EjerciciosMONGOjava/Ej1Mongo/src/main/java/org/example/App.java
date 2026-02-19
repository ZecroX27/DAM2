package org.example;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;

public class App 
{
    public static void main( String[] args )
    {
        //Conexión a la base de datos la cual es de mongodb, con nuestra ip y con el puerto por defecto de monogdb
        MongoClient cliente = MongoClients.create("mongodb://localhost:27017");
        //Tenemos que indicar la base de datos con la que queremos operar
        MongoDatabase db = cliente.getDatabase("discos");
        //Tenemos que indicar tambien en la colección con la que vamos a manipular los datos
        MongoCollection<Document> colección = db.getCollection("disco");

        Document doc = new Document();
        Document doc2 = new Document();

        List<Document> documentos = new ArrayList<>();
        documentos.add(doc);
        documentos.add(doc2);

        doc.append("_id", new ObjectId());
        doc.append("Titulo", "BLA BLA BLA");
        doc.append("Musico", "tulipan");
        doc.append("Precio", 15);
        doc.append("Genero", "asdfgsd");

        doc2.append("_id", new ObjectId());
        doc2.append("Titulo", "ASFASFAS");
        doc2.append("Musico", "bad bunny");
        doc2.append("Precio", 40);
        doc2.append("Genero", "pasoe");

        //- listar un disco con un id determinado

        ObjectId idBusqueda = new ObjectId("69976319c7b57b54fb03c62b");

        System.out.println("Listar un disco con un id determinado");
        Bson filtro = Filters.eq("_id", idBusqueda);
        MongoCursor<Document> consulta = colección.find(filtro).iterator();

        while (consulta.hasNext()){
            Document documento = consulta.next();
            System.out.println(documento.toJson());
        }
    //    colección.insertMany(documentos);

       // - listar los discos de precio inferior a 10 o superior a 20

        System.out.println("Listar los discos de precio inferior a 10 o superior a 20");
        filtro = Filters.or(Filters.lt("Precio", 10), Filters.gt("Precio", 20));
        consulta = colección.find(filtro).iterator();

        while (consulta.hasNext()){
            Document documento = consulta.next();
            System.out.println(documento.toJson());
        }

        //- incrementar en 5 euros el precio de los discos de la anterior consulta

        System.out.println("incrementar en 5 euros el precio de los discos de la anterior consulta");
        Bson incrementar = Updates.inc("Precio", 5);
        colección.updateMany(filtro , incrementar);

        //actualiza el disco (7,"Love supreme","John Coltrane","jazz", 25) con un upsert
        filtro = Filters.eq("id", 7); //Filtro de la busqueda
        Bson upsert = Updates.combine(                  //Campos que queremos actualizar
                Updates.set("Titulo", "Love supreme"),
                Updates.set("Musico", "John Coltrane"),
                Updates.set("Genero", "Jazz"),
                Updates.set("Precio", 25)
        );
        UpdateOptions opciones = new UpdateOptions().upsert(true);      //Activamos el upsert

        colección.updateOne(filtro, upsert, opciones); //Ejecución de consulta
        System.out.println("DISCO ACTUALIZADO");
    }

}
