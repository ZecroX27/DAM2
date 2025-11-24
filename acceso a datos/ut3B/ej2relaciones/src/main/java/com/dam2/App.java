package com.dam2;

import ej2relaciones.Empleado;
import ej2relaciones.Empresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();
        Empresa empresa = new Empresa("Congelados Martínez");
        Empleado empleado = new Empleado("Alexander Luzarraga", 2000, empresa);
        ss.persist(empleado);
        ss.persist(empresa);
    }
}


