package EjercicosUT1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
6. Programa que, partiendo de un array estático de enteros con los 100 primeros números naturales (de 1 a 100),
genere un buffer con esos valores y escriba éste a un fichero "nums.dat".

 Después el programa ha de hacer un "Scattering and gathering": leer de nums.dat y separar en 2 buffers nuevos los primeros 50 números y los 50 últimos.
 A partir de estos 2 últimos buffers, reunir todos los valores del segundo seguidos de los valores del primer buffer en un nuevo fichero "nums2.dat".
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocateDirect(100 * Integer.BYTES);
        int numeros [] = new int[100];
        for (int i = 1; i <= 100; i++) {
            numeros[i-1] = i;
            bf.putInt(numeros[i-1]);
        }
        try (FileChannel fc = FileChannel.open(Paths.get("nums.dat"), StandardOpenOption.WRITE,StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
             ScatteringByteChannel sbc = FileChannel.open(Paths.get("nums.dat"), StandardOpenOption.READ);
             GatheringByteChannel gbc = FileChannel.open(Paths.get("nums2.dat"), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);){
             bf.flip();
             fc.write(bf);
             ByteBuffer bb = ByteBuffer.allocateDirect(100 * Integer.BYTES / 2);
             ByteBuffer bb2 = ByteBuffer.allocateDirect(100 * Integer.BYTES / 2);
             ByteBuffer Bufferes [] = {bb, bb2};
             sbc.read(Bufferes);
             bb.flip();
             bb2.flip();
             gbc.write(Bufferes);
             System.out.println("Bufferes volcados correctamente");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
