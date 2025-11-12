package EjercicosUT1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
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
        //Lleno los Bufferes para ser escritos
        for (int i = 1; i <= 20; i++){
            if (i % 2 == 0){
                intBufferPares.putInt(i);
            }
            else{
                intBufferImpares.putInt(i);
            }

        }


        try(FileChannel fc = FileChannel.open(Paths.get("numeros.dat"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            ScatteringByteChannel sbc = FileChannel.open(Paths.get("numeros.dat"), StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            GatheringByteChannel gbc = FileChannel.open(Paths.get("numeros2.dat"), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);){
           //Preparo los Bufferes para escribir
            intBufferPares.flip();
            intBufferImpares.flip();
            //Una vez flipeados los escribo en el canal (numeros.dat)
            fc.write(intBufferPares);
            fc.write(intBufferImpares);

            //Creo una array con los 4  Bufferes  de 20 bytes cada uno
            ByteBuffer buffer1 = ByteBuffer.allocate(20);
            ByteBuffer buffer2 = ByteBuffer.allocate(20);
            ByteBuffer buffer3 = ByteBuffer.allocate(20);
            ByteBuffer buffer4 = ByteBuffer.allocate(20);
            ByteBuffer [] buffers  = {buffer1,buffer2,buffer3,buffer4};
            //Leo el contenido para almacenar los datos del fichero en mis Bufferes
            sbc.read(buffers);
            //Preparo estos dos Bufferes para ser escritos
            buffer1.flip();
            buffer3.flip();

            ByteBuffer [] BuffersEscritura = {buffer1, buffer3};
            //Escribo en el fichero numeros2.dat
            gbc.write(BuffersEscritura);



        }
        catch (IOException E){
            E.printStackTrace();
        }

    }
}
