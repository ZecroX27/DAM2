package com.dam2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App
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
            File f1 = new File("productos.xml");
            JAXBContext contexto = JAXBContext.newInstance(
                    productos.getClass() );
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(productos, f1);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
