package EjercicosUT1;
/*
0. Crea un objeto FileSystem a partir de la clase FileSystems. A partir del primero, obtén un objeto Path asociado al fichero a crear con el nombre "textos.txt".
Utilizando algún método estático de la clase Files escribe "Primera línea\n" y "Segunda línea\n" en dicho fichero.
Asegúrate de que se crea al escribir, truncando el contenido del fichero si ya existiera de ejecuciones anteriores.
Acaba mostrando el contenido del fichero haciendo uso también de algún otro método estático de la clase Files.
*/

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Ejercicio0 {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("texto.txt");
        String texto = "Primera linea \n";
        try{
            Files.writeString(path,texto,StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            String texto2 = "Segunda linea \n";
            Files.writeString(path,texto2,StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(path);
            for(String line : lines){
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
