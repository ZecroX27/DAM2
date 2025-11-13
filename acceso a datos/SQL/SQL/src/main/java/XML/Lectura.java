package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Lectura {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File("productos.xml"));

            NodeList productos = documento.getElementsByTagName("Producto");
            for (int i = 0; i < productos.getLength(); i++) {
                Node producto = productos.item(i);
                Element elemento = (Element) producto;
                System.out.println(elemento.getElementsByTagName("Nombre").item(0).getChildNodes().item(0).getNodeValue());
                System.out.println(elemento.getElementsByTagName("Precio").item(0).getChildNodes().item(0).getNodeValue());
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
