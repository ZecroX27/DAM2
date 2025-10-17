package com.dam2.ut1.ejemplos.jaxb;
// JAXB lectura
import com.dam2.ut1.ejemplos.Empleados;

import javax.xml.bind.*;
import java.io.*;
public class Jaxb2 {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance( Empleados.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Empleados empleados = (Empleados) unmarshaller.unmarshal(new File("empleadosJAXB.xml") );
            System.out.println(empleados);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
