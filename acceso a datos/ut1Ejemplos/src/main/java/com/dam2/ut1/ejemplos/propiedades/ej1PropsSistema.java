package com.dam2.ut1.ejemplos.propiedades;

public class ej1PropsSistema {
    public static void main(String[] args) {
        System.out.println("La carpeta de inicio de mi usuario es " + System.getProperty("user.home"));
        System.out.println("El directorio de trabajo actual es"   + System.getProperty("user.dir"));
        System.out.println("El Sistema operativo es " + System.getProperty("os.name") + " y la versión es " + System.getProperty("os.version"));
    }
}
