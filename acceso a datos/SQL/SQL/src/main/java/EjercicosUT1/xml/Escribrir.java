package EjercicosUT1.xml;

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

public class Escribrir {
    public static void main(String[] args) {
        com.dam2.Producto p1 = new com.dam2.Producto("pepe", 5.67);
        com.dam2.Producto p2 = new com.dam2.Producto("pepa", 5.67);
        List<com.dam2.Producto> productos = new ArrayList<com.dam2.Producto>(){{add(p1);add(p2);}};

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            Document documento = dom.createDocument(null, "xml", null);
            Element raiz = documento.getDocumentElement();


            Element nodoProducto = null , nodoDatos = null;
            Text texto = null;

            for (com.dam2.Producto producto : productos) {
                nodoProducto = documento.createElement("producto");
                raiz.appendChild(nodoProducto);

                nodoDatos = documento.createElement("nombre");
                nodoProducto.appendChild(nodoDatos);
                texto = documento.createTextNode(producto.getNombre());
                nodoDatos.appendChild(texto);

                nodoDatos = documento.createElement("precio");
                nodoProducto.appendChild(nodoDatos);
                texto = documento.createTextNode(String.valueOf(producto.getPrecio()));
                nodoDatos.appendChild(texto);
            }
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("oscar.xml"));
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
