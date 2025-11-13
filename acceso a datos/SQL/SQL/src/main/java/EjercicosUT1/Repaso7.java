package EjercicosUT1;
/*
/*
7. Programa que haga uso de canales y buffers para gestionar información de empleados.

 Se parte de un array de enteros que contiene, ordenados de la siguiente manera:

   * Primero todos los identificadores de los empleados.
   * Después, todas las horas trabajadas.
   * Finalmente, todas las tarifas por hora.

   Por ejemplo:

   { id1, id2, id3, horas1, horas2, horas3, tarifa1, tarifa2, tarifa3 }

	El programa debe:
   a) Escribir este array en un fichero binario (emp.dat) utilizando un FileChannel y un ByteBuffer.
   b) Volver a leer el fichero con un ScatteringByteChannel, de manera que cada parte quede en un `ByteBuffer` distinto (uno para IDs, otro para horas y otro para tarifas).
   c) Calcular, para cada empleado, el sueldo correspondiente (horas * tarifa) y mostrarlo por pantalla.
   d) Escribir un segundo fichero (emp2.dat) con un GatheringByteChannel, que contenga para cada empleado su identificador y el sueldo correspondiente.
 */

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Repaso7 {
    public static void main(String[] args) {
        int array [] = new int[]{1,2,3,30,35,40,7,8,9};
        ByteBuffer buffer = ByteBuffer.allocate(array.length*Integer.BYTES);
        for (int i = 0; i < array.length; i++){
            buffer.putInt(array[i]);
        }
        buffer.flip();
        try(FileChannel fc = FileChannel.open(Paths.get("emple.dat"), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            ScatteringByteChannel sbc = FileChannel.open(Paths.get("emple.dat"), StandardOpenOption.READ);
            GatheringByteChannel gbc = FileChannel.open(Paths.get("emple2.dat"), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);){
            fc.write(buffer);
            ByteBuffer b1Lectura = ByteBuffer.allocate(Integer.BYTES * 3);
            ByteBuffer b1Lectura2 = ByteBuffer.allocate(Integer.BYTES * 3);
            ByteBuffer b1Lectura3 = ByteBuffer.allocate(Integer.BYTES * 3);
            sbc.read(new ByteBuffer[]{b1Lectura,b1Lectura2,b1Lectura3});

            b1Lectura.flip();
            b1Lectura2.flip();
            b1Lectura3.flip();
            ByteBuffer b1Lectura4 = ByteBuffer.allocate(Integer.BYTES * 3);
            for (int i = 0; i < 3; i++){
                int salario = b1Lectura2.getInt()*b1Lectura3.getInt();
                System.out.println("El salario del empleado " + b1Lectura.getInt()  + " es de" + salario);
                b1Lectura4.putInt(salario);
            }
            b1Lectura4.flip();
            b1Lectura.rewind();
            gbc.write(new ByteBuffer[]{b1Lectura,b1Lectura4});
            b1Lectura4.flip();
            b1Lectura.flip();
            while(b1Lectura.hasRemaining()){
                System.out.println("El salario del empleado " + b1Lectura.getInt()  + " es de" +b1Lectura4.getInt());
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
