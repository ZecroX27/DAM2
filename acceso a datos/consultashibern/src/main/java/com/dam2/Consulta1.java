package com.dam2;

import com.dam2.ch.Persona;
import com.dam2.ch.Telefono;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLOutput;
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

        System.out.println();
        System.out.println("Las direcciones de las personas \n");
        System.out.println();
        s = "select direccion from Persona";
        query = ss.createQuery(s);
        System.out.println(query.getResultList());


        System.out.println();
        System.out.println("TELEFONOS DE LA PERSONA CON ID 1");
        System.out.println();

        s = "select tlfs, nom from Persona WHERE id = 1";
        query = ss.createQuery(s);
        Iterator ite = query.stream().iterator();

        while (ite.hasNext()) {
            Object [] obj = (Object[]) ite.next();
            System.out.println(  obj[0] + " Nombre  " + obj[1] );
        }

        System.out.println();
        System.out.println("TELEFONOS DE LA PERSONA CON ID 1 ORDENADOS ASCENDENTEMENTE");
        System.out.println();
        s = "select tlfs from Persona WHERE id = 1 order by  id asc";
        query = ss.createQuery(s);
        System.out.println(query.getResultList());

        System.out.println();
        System.out.println("CUÁNTOS TELÉFONOS TIENE CADA PERSONA SIN MOSTRAR A LA PERSONA");
        System.out.println();
        s = "select size(tlfs) from Persona";
        query = ss.createQuery(s);
        System.out.println(query.getResultList());

        System.out.println("TELEFONOS DE LA PERSONA MOSTRANDOS SU NOMBRRE");
        s = "SELECT p.nom, count(t) from Persona p, Telefono t where t.persona.id = p.id group by p.nom";
        query = ss.createQuery(s);
        Iterator it = query.stream().iterator();

        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            System.out.println(obj[0] + " -> Cantidad de numero de telefonos " + obj[1]);
        }
        System.out.println();
        System.out.println("OBTENER PERSONA CON ID IGUAL A 1");
        // OBTENER PERSONA CON ID IGUAL A 1
        int personaId = 1;
        s = "FROM Persona WHERE id = " + personaId;
        query = ss.createQuery(s);
        System.out.println(query.getResultList());

        System.out.println();
        System.out.println("OBTENER PERSONA CON EL TELEFONO 666555442");
        // OBTENER DATOS DE LA PERSONA CON TELÉFONO 666555442
        s = "SELECT t.persona.nom FROM Telefono t WHERE t.num = '666555442'";
        query = ss.createQuery(s);
        System.out.println(query.getResultList());
/*
        // REPETIR LA CONSULTA ANTERIOR CON HQL
        s ="Select p from ... where ...";
        ...
        ....uniqueResult();
        System.out.println("\n" +...);

 */

    }

}
