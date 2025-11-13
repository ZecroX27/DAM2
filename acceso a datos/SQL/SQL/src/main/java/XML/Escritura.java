package XML;

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
import java.awt.*;
import java.io.File;
import java.io.StringWriter;

public class Escritura {
    public static void main(String[] args) {
        Producto p1 = new Producto("Cereales", 2.17);
        Producto p2 = new Producto("Papel", 1.67);
        Producto[] productos = new Producto[]{p1, p2};
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            Document documento = dom.createDocument(null, "xml", null);

            Element raiz = documento.createElement("Productos");
            documento.getDocumentElement().appendChild(raiz);

            Element nodoProductos = null, nodoDatos = null;
            Text texto = null;

            for (Producto producto : productos) {
                nodoProductos = documento.createElement("Producto");
                raiz.appendChild(nodoProductos);

                nodoDatos = documento.createElement("Nombre");
                nodoProductos.appendChild(nodoDatos);
                texto = documento.createTextNode(producto.getNombre());
                nodoDatos.appendChild(texto);

                nodoDatos = documento.createElement("Precio");
                nodoProductos.appendChild(nodoDatos);
                texto = documento.createTextNode(String.valueOf(producto.getPrecio()));
                nodoDatos.appendChild(texto);
            }
                Source source = new DOMSource(documento);
                Result result = new StreamResult(new File("productos.xml"));
                Transformer tf = TransformerFactory.newInstance().newTransformer();
                tf.setOutputProperty("indent", "yes");
                tf.transform(source,result);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
