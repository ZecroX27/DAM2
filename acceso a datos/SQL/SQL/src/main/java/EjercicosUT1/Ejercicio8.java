package EjercicosUT1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
8. Crea un programa que:

 Genero un fichero notas.dat con las notas de 10 alumnos (cada alumno tiene: ID (int) + Nota (float))

 Lea el fichero haciendo scattering: un buffer para los IDs y otro para las Notas

 Calculo la media de las notas

 Escriba en un nuevo fichero media.txt el resultado usando gathering: un buffer por el texto y otro por el valor numérico.
 */
public class Ejercicio8 {
    public static void main(String[] args) {
             //Abro el fichero notas.dat con el FileChannel
        try (FileChannel fc = FileChannel.open(Paths.get("notas.dat"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);){
            //Creo 2 Bufferes para almacenar tanto como el ID y las NOTAS
            ByteBuffer bbInt = ByteBuffer.allocate(10*Integer.BYTES);
            ByteBuffer bbNota = ByteBuffer.allocate(10*Float.BYTES);
            for (int i = 1; i <= 10; i++) {
                bbInt.putInt(i); //Establezco los IDS en el buffer
            }
            for (int i = 1; i <= 10; i++) {
                bbNota.putFloat((float)(Math.random( ) * 10)); //Establezco las notas en el buffer
            }
            bbInt.flip();//Vuelvo a la posicion inicial
            bbNota.flip();//Vuelvo a la posicion inicial
            fc.write(bbInt);//Escribo lo que tengo en el buffer mediante el FileChannel
            fc.write(bbNota);//Escribo lo que tengo en el buffer mediante el FileChannel

        }
        catch (IOException E){
            E.printStackTrace();
        }
            //Creo eun Scattering para la lectura del fichero y un Gathering para escribir
        try (ScatteringByteChannel sbc = FileChannel.open(Paths.get("notas.dat"), StandardOpenOption.READ);
             GatheringByteChannel gbc = FileChannel.open(Paths.get("media.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.READ);){
            //Creo los bufferes para poder leer la informacion del fichero
            ByteBuffer bbInt = ByteBuffer.allocate(10*Integer.BYTES);
            ByteBuffer bbNota = ByteBuffer.allocate(10*Float.BYTES);
            ByteBuffer bufferes [] = new ByteBuffer []{bbInt, bbNota};
            //Leo la informacion del fichero
            sbc.read(bufferes);
            //Y vuelvo a la posicion inicial
            bbInt.flip();
            bbNota.flip();

            //Calculo la media de las notas
            float media = 0;
            int cont = 0;
            while (bbNota.hasRemaining()) {

                cont++;
                media = media + bbNota.getFloat();

            }
            media = media / cont;
            String text = "Promedio de las notas ";
            //Escribo en el fichero el String del promedio
            ByteBuffer textBuffer = ByteBuffer.wrap(text.getBytes(StandardCharsets.UTF_8));
            ByteBuffer nota_media = ByteBuffer.allocate(1*Float.BYTES);
            //Escribo en el fichero la media de las notas con Gathering
            nota_media.putFloat(media);
            nota_media.flip();
            gbc.write(new ByteBuffer[]{textBuffer, nota_media});
        }
        catch (IOException E){
            E.printStackTrace();
        }

    }
}
