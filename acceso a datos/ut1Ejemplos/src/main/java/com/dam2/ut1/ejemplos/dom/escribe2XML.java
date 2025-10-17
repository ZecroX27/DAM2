package com.dam2.ut1.ejemplos.dom;

import com.dam2.ut1.ejemplos.Empleado;
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

public class escribe2XML {
	public static void main(String[] args) {
		//ArrayList con los datos de los empleados
		List<Empleado> listaEmpleados=new ArrayList<>();
		listaEmpleados.add(new Empleado(1,"Pepe Pérez",2000));
		listaEmpleados.add(new Empleado(2,"Julián Martínez",1000));
		listaEmpleados.add(new Empleado(3,"Sergio García",1500));

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation dom = builder.getDOMImplementation();
			Document documento = dom.createDocument(null, "xml", null);
			Element raiz = documento.createElement("Empleados");
			documento.getDocumentElement().appendChild(raiz);
			Element nodoProducto = null , nodoDatos = null ;
			Text texto = null;

			for(Empleado emp: listaEmpleados){
			//Empleado
				nodoProducto=documento.createElement("Empleado");
					raiz.appendChild(nodoProducto);
			//Id
				nodoDatos=documento.createElement("Id");
					nodoProducto.appendChild(nodoDatos);
					texto=documento.createTextNode(String.valueOf(emp.getId()));
						nodoDatos.appendChild(texto);
			//Nombre
				nodoDatos=documento.createElement("Nombre");
					nodoProducto.appendChild(nodoDatos);
					texto=documento.createTextNode(emp.getNom());
						nodoDatos.appendChild(texto);
			//Salario
				nodoDatos=documento.createElement("Salario");
					nodoProducto.appendChild(nodoDatos);
					texto=documento.createTextNode(String.valueOf(emp.getSalario()));
						nodoDatos.appendChild(texto);
			}
			Source source = new DOMSource(documento);
			Result resultado = new StreamResult(new File("empleados.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty("indent","yes");
			transformer.transform(source,resultado);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}
	}
}
