/*
3. Hacer un programa que, utilizando canales y búferes NIO, haga una copia de un fichero de texto en otro fichero donde las minúsculas sean convertidas a mayúsculas.
Resuélvelo haciendo la transformación de cada caracter avanzando posición a posición en el buffer, leyendo y escribiendo con get() y put(), y ayudándote de mark() y reset()
para retornar a la posición anterior.
 */

import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio3 {
    public static void main(String[] args) {
        Path origen = Paths.get("texto ej3.txt");
        Path destino = Paths.get("texto2 ej3.txt");
    }
}