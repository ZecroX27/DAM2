package com.dam2;

import com.dam2.ej2relaciones.Deporte;
import com.dam2.ej2relaciones.Empleado;
import com.dam2.ej2relaciones.Empresa;
import com.dam2.ej2relaciones.Usuario;
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

        //Deporte deporte1 = new Deporte("Pádel");

        empresa.getEmpleados().add(empleado1);
        empresa.getEmpleados().add(empleado2);

        empleado1.setDeporte(new Deporte("Pádel"));
        empleado2.setDeporte(new Deporte("Futbol Sala"));

        Usuario user1 = new Usuario("El mago", "1234");
        Usuario user2 = new Usuario("Sebastian", "1234*");

        user1.setEmpleado(empleado1);
        user2.setEmpleado(empleado2);

        empleado1.setUsuario(user1);
        empleado2.setUsuario(user2);


        //ss.persist(empleado);
        //ss.persist(empresa);

        ss.persist(empresa);
        tr.commit();
    }
}


