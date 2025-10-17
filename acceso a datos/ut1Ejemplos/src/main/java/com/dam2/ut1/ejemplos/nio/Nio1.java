package com.dam2.ut1.ejemplos.nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/* Programa con 3 parámetros:
    java Nio1  /ruta/fichero/lectura  /ruta/fichero/escritura  numLínea
    Añade la línea indicada del fichero de lectura al fichero de escritura

    Los parámetros a main los puedes pasar desde Run --> Edit configurations --> Build and
    run (bajo la versión de Java)
 */

public class Nio1 {
    public static void main(String[] args) {
        int cont=0;
        if (args.length > 2)
        {
            Path pathR = Paths.get(args[0]);
            Path pathW = Paths.get(args[1]);
            //Files.copy(pathR,pathW,)
            try {
                List<String> lines = Files.readAllLines(pathR);
                // SE QUEDA CON LA LÍNEA INDICADA POR EL TERCER PARÁMETRO
                String line = lines.get(Integer.parseInt(args[2]));
                Files.writeString(pathW,line + "\n", StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
