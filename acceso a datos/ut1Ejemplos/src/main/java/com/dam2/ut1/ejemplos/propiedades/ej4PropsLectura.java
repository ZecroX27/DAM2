package com.dam2.ut1.ejemplos.propiedades;

import java.util.*;
import java.nio.*;
import java.io.*;

public class ej4PropsLectura
{
	public static void main(String[] args) 
	{
		String usuario,password,servidor;
		int puerto;
		Properties configuracion = new Properties();
		try 
		{
			configuracion.load(new FileInputStream("configuracion.props"));
			/*System.out.println(usuario = configuracion.getProperty("user"));
			System.out.println(password = configuracion.getProperty("password"));
			System.out.println(servidor = configuracion.getProperty("server"));
			System.out.println(puerto = Integer.valueOf(configuracion.getProperty("port")));*/
            configuracion.list(System.out);
		} 
			catch (FileNotFoundException fnfe ) 
		{
			fnfe.printStackTrace();
		} 
			catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}	
	}
}
