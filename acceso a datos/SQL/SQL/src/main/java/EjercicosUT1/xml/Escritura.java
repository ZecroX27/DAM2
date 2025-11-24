package com.dam2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Escritura
{
    public static void main( String[] args )
    {
        // paso 1: crear productos
        Producto p1 = new Producto("teclado",15);
        Producto p2 = new Producto("monitor 17",75);
        List<Producto> prs = new ArrayList<>();
        prs.add(p1);
        prs.add(p2);
        Productos productos = new Productos(prs);

        // paso 2: crear FICHERO xml
        try {
            JAXBContext contexto = JAXBContext.newInstance(
                    productos.getClass() );
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            //marshaller.marshal(productos, new File("productos.xml"));
            marshaller.marshal(productos, new FileOutputStream("productos.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
