package com.dam2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/*
1. Realiza con Hibernate la aplicación para gestión de bibliotecas "Vinalopó" (con sedes en Elda, Petrer, Novelda, Monóvar, Villena, Sax ...)
que genere las tablas, todas, con al menos una instancia, a partir de las siguientes relaciones.

	- relación unidireccional N a N entre Libro y Autor, un libro tiene una lista de autores
	- relación 1 a 1 entre Autor y Biografía
	- N a N entre Libro y Biblioteca
	- 1 a N entre Editorial y Libro
	- Generalización entre Artículo, Disco y Libro con estrategia de tabla única y clase base abstracta

Todas las clases tendrán como clave principal un "Long id". El resto de atributos serán, como mínimo:

	Articulo (titulo)
	Libro(isbn)
	Disco(duracion)
	Autor(nombre, añoNacimiento)
	Biografia(memo o descripción)
	Biblioteca(localidad)
	Editorial(nombre)
*/
public class App 
{
    public static void main( String[] args ){

        SessionFactory sf = new HibernateUtil().getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        Disco disco = new Disco("TransComunity", 50);
        Editorial editorial = new Editorial("Santillana");
        Libro libro = new Libro("Geronimo Stilton", "34534", editorial);
        Biblioteca biblioteca = new Biblioteca("Petrer");
        Biografia biografia = new Biografia("HOLAAAAA");
        Autor autor = new Autor("Iniesta", 1990, biografia);
        //List<Biblioteca> bibliotecas = new ArrayList<>();
        //bibliotecas.add(biblioteca);

        biografia.setAutor(autor);
        libro.getBibliotecas().add(biblioteca);
        biblioteca.getLibros().add(libro);
        libro.getAutores().add(autor);
        autor.setBiografia(biografia);


        session.persist(libro);
        session.persist(disco);
        session.persist(autor);
        tx.commit();
        session.close();


    }
}
