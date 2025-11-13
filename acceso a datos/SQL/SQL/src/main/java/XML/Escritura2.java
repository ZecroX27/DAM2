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
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Escritura2 {
    public static void main(String[] args) {
        Producto producto = new Producto("Jabon", 5.67);
        Producto producto2 = new Producto("Jamon de Bellota", 300.67);
        List<Producto> productos = new ArrayList<Producto>(){{add(producto);add(producto2);}};


        try{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            Document documento = dom.createDocument(null, "xml", null);

            Element raiz = documento.createElement("Productos");
            documento.getDocumentElement().appendChild(raiz);
            Element nodoProducto = null, nodoDatos = null;
            Text texto = null;

            for (Producto p : productos) {
                nodoProducto = documento.createElement("Producto");
                raiz.appendChild(nodoProducto);

                nodoDatos = documento.createElement("Nombre");
                nodoProducto.appendChild(nodoDatos);
                texto = documento.createTextNode(p.getNombre());
                nodoDatos.appendChild(texto);

                nodoDatos = documento.createElement("Precio");
                nodoProducto.appendChild(nodoDatos);
                texto = documento.createTextNode(String.valueOf(p.getPrecio()));
                nodoDatos.appendChild(texto);
            }
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("productos2.xml"));
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
