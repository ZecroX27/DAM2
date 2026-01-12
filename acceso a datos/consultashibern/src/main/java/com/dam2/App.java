package com.dam2;

import com.dam2.ch.Persona;
import com.dam2.ch.Telefono;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Persona per1 = new Persona("David Font","c/ Pablo Iglesias, 23");
        Telefono tf1 = new Telefono("666555444", per1);
        per1.getTlfs().add(tf1);

        Telefono tf2 = new Telefono("666555443", per1);
        per1.getTlfs().add(tf2);

        Persona per2 = new Persona("Manuel Font","c/ Joan Fuster, 46");
        Telefono tf3 = new Telefono("666555442", per2);
        per2.getTlfs().add(tf3);

        ss.persist(per1);
        ss.persist(per2);
        t.commit();
    }
}
