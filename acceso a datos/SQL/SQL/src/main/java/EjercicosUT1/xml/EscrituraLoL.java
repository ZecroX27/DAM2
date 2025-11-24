package com.dam2;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class EscrituraLoL {
    public static void main(String[] args) {


        Producto p1 = new Producto("Seat Leon", 23000.99);
        Producto p2 = new Producto("Subaru Impreza", 10000.00);

        Producto[] productos = new Producto[]{p1, p2};

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            Document documento = dom.createDocument(null, "xml", null);
            Element raiz = documento.createElement("productos");
            documento.getDocumentElement().appendChild(raiz);
            Element nodoProducto = null;
            Element nodoDatos = null;
            Text text= null;

            for(Producto producto : productos){
                nodoProducto = documento.createElement("producto");
                raiz.appendChild(nodoProducto);
                nodoDatos = documento.createElement("Nombre");
                nodoProducto.appendChild(nodoDatos);
                text = documento.createTextNode(producto.getNombre());
                nodoDatos.appendChild(text);
                nodoDatos = documento.createElement("Precio");
                nodoProducto.appendChild(nodoDatos);
                text = documento.createTextNode(String.valueOf(producto.getPrecio()));
                nodoDatos.appendChild(text);
            }

            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("Concesionario.xml"));
            Transformer tf = TransformerFactory.newInstance().newTransformer();

            tf.setOutputProperty("indent", "yes");

            tf.transform(source, result);



        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }
}
