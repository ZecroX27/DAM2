package com.dam2;

import com.dam2.ch.Persona;
import com.dam2.ch.Telefono;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Consulta1 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        // OBTENER TODAS LAS PERSONAS
        System.out.println("OBTENER TODAS LAS PERSONAS \n");
        String s = "from Persona";
        Query query = ss.createQuery(s);
        System.out.println(query.getResultList());

        System.out.println("Las direcciones de las personas \n");
        System.out.println();
        s = "select direccion from Persona";
        query = ss.createQuery(s);
        System.out.println(query.getResultList());


        System.out.println("TELEFONOS DE LA PERSONA CON ID 1");
        System.out.println();
        s = "select tlfs from Persona WHERE id = 1";
        query = ss.createQuery(s);
        System.out.println(query.getResultList());

        System.out.println("TELEFONOS DE LA PERSONA CON ID 1 ORDENADOS ASCENDENTEMENTE");
        System.out.println();
        s = "select tlfs from Persona WHERE id = 1 order by  id asc";
        query = ss.createQuery(s);
        System.out.println(query.getResultList());

        System.out.println("CUÁNTOS TELÉFONOS TIENE CADA PERSONA SIN MOSTRAR A LA PERSONA");
        System.out.println();
        s = "select size(tlfs) from Persona";
        query = ss.createQuery(s);
        System.out.println(query.getResultList());

        System.out.println("CUÁNTOS TELÉFONOS TIENE CADA PERSONA MOSTRANDO A CADA PERSONA");
        System.out.println();
        s = "select size(tlfs), nom from Persona  group by id";
        Query q = ss.createQuery(s);
        Iterator it = q.stream().iterator();
        while (it.hasNext())
        {
            Object array[] = (Object[]) it.next();
            Persona p = (Persona) array[0];
            System.out.println(p);

        }
/*
        // OBTENER PERSONA CON ID IGUAL A 1
        int personaId = 1;
        Persona p = ss.get(...);
        System.out.println("\n" + p);

        // OBTENER DATOS DE LA PERSONA CON TELÉFONO 666555442
        String s2 = "666555442";
        Telefono tlf = ss.get(...);
        System.out.println("\n" +...);

        // REPETIR LA CONSULTA ANTERIOR CON HQL
        s ="Select p from ... where ...";
        ...
        ....uniqueResult();
        System.out.println("\n" +...);

 */



    }

}
