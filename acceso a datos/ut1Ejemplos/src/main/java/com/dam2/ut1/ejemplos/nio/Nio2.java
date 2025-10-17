package com.dam2.ut1.ejemplos.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/* Programa que admita como parámetro la ruta a un directorio y liste
su contenido
 */

public class Nio2 {
    public static void main(String[] args) {
        if (args.length > 0) {
            Path dir = Paths.get(args[0]);
            if (Files.isDirectory(dir)){
                Stream<Path> list = null;
                try {
                    list = Files.list(dir);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.forEach(e ->
                        {
                            System.out.print(e.getFileName());
                            if (Files.isDirectory(e))
                                System.out.println(" és un directori");
                            else
                                System.out.println(" és un fitxer regular");
                        } );
        }
            else
                System.out.println("No és un directori");
        } else {
            System.out.println("Falta el paràmetre");
        }
        }
    }
