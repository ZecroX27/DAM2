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

package com.dam2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args ){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        Libro libro = new Libro("Hola", "1");

        Disco disco = new Disco("Feid", 10);

        Editorial ed1 = new Editorial("Santillana");

        Autor aut1 = new Autor("Bbtrickz", 2001 );

        Biografia biografia = new Biografia("Yo quiero singa", aut1);

        Biblioteca biblio = new Biblioteca("Petrer");

        aut1.setBiografia(biografia);
        biblio.addLibros(libro);

        ed1.getLibros().add(libro);

        libro.setEditorial(ed1);
        libro.addAutor(aut1);

        session.persist(libro);
        session.persist(disco);
        session.persist(aut1);
        session.persist(biblio);

        t.commit();
        session.close();

    }



}
