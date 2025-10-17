/*0. Crea un objeto FileSystem a partir de la clase FileSystems. A partir del primero, obtén un objeto Path asociado al fichero a crear con el nombre "textos.txt".
Utilizando algún método estático de la clase Files escribe "Primera línea\n" y "Segunda línea\n" en dicho fichero. Asegúrate de que se crea al escribir,
truncando el contenido del fichero si ya existiera de ejecuciones anteriores.Acaba mostrando el contenido del fichero haciendo uso también de algún otro método estático
de la clase Files.*/
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ejercicio0 {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        File f = new File("textos.txt");
        Path p  = fs.getPath("textos.txt");
        List<String> lineas = Arrays.asList("Primera linea", "Segunda linea");
        try {
            Files.write(f.toPath(),lineas , StandardOpenOption.CREATE);
            System.out.println("Contenido del fichero" + Files.readAllLines(p));;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
