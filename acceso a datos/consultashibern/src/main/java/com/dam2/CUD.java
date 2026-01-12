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

        // INSERTAR EL TELEFONO 666111222 CON PROPIETARIO LA PERSONA CON ID 1
        String hql = "INSERT ...";

        // EL TLF 666555443 SE LO ASIGNO A LA PERSONA CON ID 2
        hql = "UPDATE ...";

        // Borrar una Persona 3 (creada para la ocasión, no existía)
        hql = "DELETE FROM ...";

    }

}
