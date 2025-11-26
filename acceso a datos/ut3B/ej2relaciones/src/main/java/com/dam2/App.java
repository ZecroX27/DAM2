package com.dam2;

import com.dam2.ej2relaciones.Empleado;
import com.dam2.ej2relaciones.Empresa;
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
        Empleado empleado1 = new Empleado("Alexander Luzarraga", 2000, empresa);
        Empleado empleado2 = new Empleado("Oscar Carrillo", 2000, empresa);
        empresa.getEmpleados().add(empleado1);
        //ss.persist(empleado);
        //ss.persist(empresa);
        ss.persist(empresa);
        tr.commit();
    }
}


