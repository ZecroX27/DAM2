package com.dam2.ut1.ejemplos.propiedades;

import java.util.*;
import java.io.*;

public class ej4bPropsModificadas {
    public static void main(String[] args) {
        try {
            Properties configuracion = new Properties();
            configuracion.load(new FileInputStream("configuracion.props"));
            String usuario = configuracion.getProperty("user");
            String password = configuracion.getProperty("password");
            String servidor = configuracion.getProperty("server");
            int puerto = Integer.valueOf(configuracion.getProperty("port"));

            Enumeration<Object> claves = configuracion.keys();
  
            while (claves.hasMoreElements()) {
                String clave = (String)claves.nextElement();
                System.out.println(clave.toString() + " = " + configuracion.get(clave));
            }

            configuracion.setProperty("user","user2");
            configuracion.setProperty("password","pass2");
            configuracion.store(new FileOutputStream("configuracion.props"), "configuracion última");
            configuracion.list(System.out);
            } catch (FileNotFoundException fnfe ) {
                fnfe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
    }
}
