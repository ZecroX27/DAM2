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
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Escrituraprueba {
    public static void main(String[] args) {
        Producto p = new Producto("Berenjena", 0.67);
        Producto p1 = new Producto("Wayaba", 3.92);
        List<Producto> lista = new ArrayList<>();
        lista.add(p);
        lista.add(p1);
        Productos ps = new Productos(lista);
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();

            Document documento = dom.createDocument(null, "xml", null); // <xml>
            Element raiz = documento.createElement("productos"); // <productos>
            documento.getDocumentElement().appendChild(raiz);
            Element nodoProducto = null;
            Element nodoDatos = null;
            Text Texto = null;

            for (Producto producto: lista){
                nodoProducto = documento.createElement("producto");
                raiz.appendChild(nodoProducto);
                nodoDatos = documento.createElement("Nombre");
                nodoProducto.appendChild(nodoDatos);
                Texto = documento.createTextNode(producto.getNombre());
                nodoDatos.appendChild(Texto);
                nodoDatos = documento.createElement("Precio");
                nodoProducto.appendChild(nodoDatos);
                Texto = documento.createTextNode(String.valueOf(producto.getPrecio()));
                nodoDatos.appendChild(Texto);


            }

            Source source = new DOMSource(documento);
            Result res = new StreamResult(new File("OscarCarillo.xml"));
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty("indent", "yes");
            tf.transform(source,res);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
