package EjercicosUT1;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ejercicio7 {
    public static void main(String[] args) {
        int array [] = new int[]{1,2,3,30,35,40,7,8,10}; //Creo la array que contiene los Id, las horas y las tarifas
        ByteBuffer bb = ByteBuffer.allocate(array.length * Integer.BYTES); //Creo el buffer en el cual voy a llenar del array anterior creado
        bb.clear();
        for (int i = 0; i < array.length; i++) {
            bb.putInt(array[i]); //Lo lleno
        }
        bb.flip(); //Vuelvo al princpio estableciendo el limite


        try(FileChannel fc = FileChannel.open(Paths.get("emp.dat"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
        //Creo el FileChannel para poder pasar la informacion de mi buffer a el fichero emp.dat
            fc.write(bb); //Escribo en el fichero mediante el canal
            System.out.println("Fichero emp.dat escrito.");

        } catch (Exception e) {
            System.err.println("Error durante la escritura de emp.dat:");
            e.printStackTrace();
        }


        try(ScatteringByteChannel scb = FileChannel.open(Paths.get("emp.dat"), StandardOpenOption.READ); //Creacion de Scattering para leer y Gathering para escribir
            GatheringByteChannel gbc = FileChannel.open(Paths.get("emp2.dat"),StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);){
            //Creo la array de bufferes que contiene cada uno el ID, las hoeras y la tarifa
            ByteBuffer bb2 = ByteBuffer.allocate(3*Integer.BYTES);
            ByteBuffer bb3 = ByteBuffer.allocate(3*Integer.BYTES);
            ByteBuffer bb4 = ByteBuffer.allocate(3*Integer.BYTES);
            ByteBuffer buffers[] = new ByteBuffer[]{bb2,bb3,bb4};
            //Limpiamos el buffer y nos ponemos en la posicion inicial para poder leer
            bb2.clear();
            bb3.clear();
            bb4.clear();
            //Leemos en el buffer
            scb.read(buffers);
            //Para poder obtener los datos que queremos tenemos que recorrer los bufferes por ello me vuelvo a la posicion inicial
            buffers[0].flip();
            buffers[1].flip();
            buffers[2].flip();
            //Buffer para poder escribir en el fichero emp2.dat el id y el salario del empleado
            ByteBuffer bbSalario = ByteBuffer.allocate(6 * Integer.BYTES);
            for(int i=0; i < 3 ; i++){
                //Guardo en sus respectivas variables los campos en sus respectivos bufferes
                int id = buffers[0].getInt();
                int horas = buffers[1].getInt();
                int tarifa = buffers[2].getInt();
                //Con la información que he obtenido imprimo los resultados por pantalla
                System.out.println("El salario del empleado " + id + " con numero de horas " + horas + " y con tarifa de " + tarifa + " es de " +horas*tarifa);
                //Antes de moverme a la siguiente posición guardo en el buffer el id y el salario
                bbSalario.putInt(id);
                bbSalario.putInt(horas*tarifa);
            }
            //Vuelvo a el principio del salario
            bbSalario.flip();
            //Con Gathering escribo el id y el salario en el fichero
            gbc.write(new ByteBuffer[] {bbSalario});
            System.out.println("Bytes escritos correctamente en emp2.dat");

        } catch (Exception e) {
            System.err.println("Error durante la lectura/escritura de salarios:");
            e.printStackTrace();
        }
    }
}