package com.dam2;

import com.dam2.ch.Persona;
import com.dam2.ch.Telefono;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class CUD {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

/*
        Persona persona = new Persona("Alberto","Camuñas");
        Telefono tlf = new Telefono("43242234", persona);
        persona.getTlfs().add(tlf);
        ss.persist(persona);

     /*   // EL TLF 666555443 SE LO ASIGNO A LA PERSONA CON ID 1
        String hql = "UPDATE Telefono t SET t.persona.id = :id WHERE t.num = :num";
        Query query = ss.createQuery(hql);
        query.setParameter("id", 1);
        query.setParameter("num", "666555442");
        int result = query.executeUpdate();
        System.out.println(result);

        */

        String hql = "DELETE FROM Telefono t WHERE t.persona.id = :idPersona";
        Query query = ss.createQuery(hql);
        query.setParameter("idPersona", 3);
        int result = query.executeUpdate();
        System.out.println("Registro Eliminado: " + result);

        hql = "DELETE FROM Persona p WHERE p.id = :idPersona";
        query = ss.createQuery(hql);
        query.setParameter("idPersona", 3);
        result = query.executeUpdate();
        System.out.println("Registro Eliminado: " + result);



        t.commit();


    }

}
