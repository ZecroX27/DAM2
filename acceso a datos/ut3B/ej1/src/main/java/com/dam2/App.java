package com.dam2;

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
        Session  ss = sf.getCurrentSession();
        Transaction tr = ss.beginTransaction();

        Empleado e1 = new Empleado("Emilio Pérez", 1700);
        Empleado e2 = new Empleado("Alfredo Martínez",1800);
        ss.persist(e1);
        ss.persist(e2);

        tr.commit();
    }
}
