package EjercicosUT1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
5. Crea 2 IntBuffers con capacidad para 10 enteros cada uno de ellos. Guarda, de entre los 20 primeros números naturales, los pares en uno y los impares en otro.
 Escribe el contenido de ambos búferes a un fichero "numeros.dat".
Lee el contenido del fichero con un ScatteringByteChannel que reparta el contenido en 4 búferes de igual tamaño.
Reune el contenido del primer y tercer buffer en un nuevo fichero con GatheringByteChannel.
 */
public class ejercicio5 {
    public static void main(String[] args) {
        ByteBuffer intBufferPares = ByteBuffer.allocate(10* Integer.BYTES);
        ByteBuffer intBufferImpares = ByteBuffer.allocate(10* Integer.BYTES);
        for (int i = 1; i <= 20; i++){
            if (i % 2 == 0){
                intBufferPares.putInt(i);
            }
            else{
                intBufferImpares.putInt(i);
            }

        }

        try(FileChannel fc = FileChannel.open(Paths.get("numeros.dat"), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            ScatteringByteChannel sbc = FileChannel.open(Paths.get("numeros.dat"));){
            intBufferPares.flip();
            fc.write(intBufferPares);
            intBufferImpares.flip();
            fc.write(intBufferImpares);
            intBufferPares.clear();
            intBufferImpares.clear();
            sbc.read(new ByteBuffer[]{intBufferPares,intBufferImpares});
            intBufferPares.flip();
            intBufferImpares.flip();

        }
        catch (IOException E){
            E.printStackTrace();
        }

        try(RandomAccessFile raf = new RandomAccessFile("numeros.dat", "r")) {
            ByteBuffer buffer = ByteBuffer.allocate(10* Integer.BYTES);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
