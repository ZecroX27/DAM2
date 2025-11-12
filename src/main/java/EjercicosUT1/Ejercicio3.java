package EjercicosUT1;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
3. Hacer un programa que, utilizando canales y búferes NIO, haga una copia de un fichero de texto en otro fichero donde las minúsculas sean convertidas a mayúsculas.
Resuélvelo haciendo la transformación de cada caracter avanzando posición a posición en el buffer, leyendo y escribiendo con get() y put(),
y ayudándote de mark() y reset() para retornar a la posición anterior
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try(FileChannel fc = FileChannel.open(Paths.get("texto.txt"),StandardOpenOption.READ);
            FileChannel fc2 = FileChannel.open(Paths.get("salida.txt"),StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);){
            do{
                buffer.clear();
                int leidos = fc.read(buffer);
                System.out.println(leidos);
                if(leidos < 0)
                    break;
                buffer.flip();
                while(buffer.hasRemaining()){
                    buffer.mark();
                    byte c = buffer.get();
                    if (c >= 97 && c <= 122)
                        c -= 32;
                    buffer.reset();
                    buffer.put(c);
                }
                buffer.rewind();
                fc2.write(buffer);

            } while (true);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
