package com.dam2.ut1.ejemplos.jaxb;

// JAXB Escriptura
import com.dam2.ut1.ejemplos.Empleado;
import com.dam2.ut1.ejemplos.Empleados;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jaxb1 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("empleadosJAXB.xml"); ){
            Empleado empleado = new Empleado(1,"Johnny Cash",4000);
            Empleado empleado2 = new Empleado(2,"Johnny Marr",3444);
            List<Empleado> llista = new ArrayList<Empleado>();
            llista.add(empleado);llista.add(empleado2);
            Empleados empleados = new Empleados(llista);
            JAXBContext contexto = JAXBContext.newInstance(
                    empleados.getClass() );
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            // SE ESCRIBEN TODOS LOS EMPLEADOS AL FW EN UNA INSTRUCCIÓN
            marshaller.marshal(empleados,fw);
        } catch (PropertyException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JAXBException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
