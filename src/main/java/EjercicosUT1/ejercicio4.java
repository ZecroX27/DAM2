package EjercicosUT1;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.util.Arrays;

/*
4. Crear un ByteBuffer para guardar 10 enteros, y guardar en él 10 números aleatorios entre 1 y 10. Escribe los 10 valores del buffer a un fichero.
Finalmente, abre el fichero para lectura y mostra su contenido. Para esto último puedes hacer uso para ello de Arrays.toString(array).
 */
public class ejercicio4 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(40);
        for (int i = 0; i < 10; i++) {
            buffer.putInt((int)(Math.random() * 10) + 1);
        }
        try(FileChannel fc = FileChannel.open(Paths.get("texto.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);){
            buffer.flip();
            fc.write(buffer);
            buffer.clear();
            fc.position(0);
            fc.read(buffer);
            buffer.flip();
            int numeros [] = new int[10];
            for (int i = 0; i < 10; i++) {
                numeros[i] = buffer.getInt();
            }
            System.out.println("Los numeros aleatorios son " + Arrays.toString(numeros));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
