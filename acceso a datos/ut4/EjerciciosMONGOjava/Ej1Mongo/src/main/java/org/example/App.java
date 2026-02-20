package org.example;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

public class yoelApp
{
    public static void main( String[] args )
    {
        MongoClient cliente = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase db = cliente.getDatabase("peliculas");

        MongoCollection<Document> coleccion = db.getCollection("peliculas");

        MongoCursor<Document> consulta;

        Document pelicula = new Document();
        pelicula.append("_id ",1)
                .append("titulo","Insidious 3")
                .append("duración", "1:27:36")
                .append("genero", Arrays.asList("Terror", "Suspense"))
                .append("imdb", 7.25);
        System.out.println("Pelicula Insertada");
        //coleccion.insertOne(pelicula);

        List<Document> pelicules = new ArrayList<>();



        Document pelicula2 = new Document();
        pelicula2.append("_id", 2)
                .append("titulo","Campeones")
                .append("duración", "infumable")
                .append("genero", Arrays.asList("ONCE", "Tengo Senocitis"))
                .append("imdb", 4.6);

        Document pelicula3 = new Document();
        pelicula3.append("_id", 3)
                .append("titulo","Weapons")
                .append("duración", "2:17:32")
                .append("genero", Arrays.asList("Terror", "Risa", "Suspense", "Intriga"))
                .append("imdb", 7.75);

        pelicules.add(pelicula2);
        pelicules.add(pelicula3);

        System.out.println("Peliculas Insertadas");
     //   coleccion.insertMany(pelicules);

        Bson filtro = Filters.eq("_id ", 1);
        consulta = coleccion.find(filtro).iterator();

        Document doc = consulta.next();
        System.out.println("Pelicula encontrada");
        System.out.println(doc.toJson());

        // - listar los discos de nota inferior a 5 o superior a 7.5

        filtro = Filters.or(lt("imdb", 5), gt("imdb", 7.5));
        consulta = coleccion.find(filtro).projection(fields(exclude("_id"), include("titulo", "imdb"))).iterator();

        while (consulta.hasNext()) {
            Document doc2 = consulta.next();
            System.out.println(doc2.toJson());
        }
        filtro = Filters.eq("titulo", "Campeones");
        Bson incrementar = Updates.inc("imdb", 2);
        //Campeones actualizados
        coleccion.updateOne(filtro, incrementar);

        consulta = coleccion.find(filtro).iterator();
        Document doc3 = consulta.next();
        System.out.println("Pelicula encontrada y Actualizada");
        System.out.println(doc3.toJson());


        filtro = Filters.eq("_id", 5);

        Bson updates = Updates.combine(
                Updates.set("titulo", "Shutter Island"),
                Updates.set("duracion", "1:50:23"),
                Updates.set("imbd", 8.9),
                Updates.set("genero", Arrays.asList("Plot-Tuist", "Intriga")
                )
        );

        UpdateOptions opciones = new UpdateOptions().upsert(true);
        //coleccion.updateOne(filtro, updates, opciones);

        consulta = coleccion.find().iterator();

        while (consulta.hasNext()) {
            Document doc4 = consulta.next();
            System.out.println(doc4.toJson());
        }
        System.out.println("Eliminando la primera pelicula");
        filtro = Filters.eq("_id ", 1);
        coleccion.deleteOne(filtro);

       // coleccion.updateOne(filtro, updates, opciones);

        consulta = coleccion.find().iterator();

        while (consulta.hasNext()) {
            Document doc4 = consulta.next();
            System.out.println(doc4.toJson());
        }






    }

}
