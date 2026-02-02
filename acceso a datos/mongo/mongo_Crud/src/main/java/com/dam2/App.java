package com.dam2;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class App
{
    public static void main( String[] args )
    {
        MongoClient cliente = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = cliente.getDatabase("mydb2");
        MongoCollection<Document> collection = database.getCollection("discos");

        Document d1 = new Document("_id", 1);
        d1.append("titulo", "TA FACIL");
        d1.append("precio", 20);
        d1.append("Autor", "LUCHO RK");

        collection.insertOne(d1);
    }
}
