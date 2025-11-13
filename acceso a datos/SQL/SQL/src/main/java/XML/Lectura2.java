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

public class Lectura2 {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File("productos2.xml"));

            NodeList list = documento.getElementsByTagName("Producto");
            for(int i = 0; i < list.getLength(); i++){
                Node nodo = list.item(i);
                Element elemento = (Element) nodo;
                System.out.println(elemento.getElementsByTagName("Nombre")
                        .item(0)
                        .getChildNodes()
                        .item(0)
                        .getTextContent());
                System.out.println(elemento.getElementsByTagName("Precio")
                        .item(0)
                        .getChildNodes()
                        .item(0)
                        .getTextContent());

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
