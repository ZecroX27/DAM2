package com.dam2.ut1.ejemplos.nio;
// nio
// còpia empleados.dat, del Raf1, anterior ( byte a byte, o de 40 en 40 )
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Nio3 {

    final static int SIZE = 40;
    static RandomAccessFile raf;
    static FileOutputStream fos;
    public static void main(String[] args) {
        // write your code here
        try {
            raf = new RandomAccessFile("empleados.dat", "r");
            fos = new FileOutputStream("empleados.nio");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel fch1 = raf.getChannel();
        FileChannel fch2 = fos.getChannel();
        //ByteBuffer bb = ByteBuffer.allocate(1024);
        ByteBuffer bb = ByteBuffer.allocate(40);
        try {
            while (fch1.read(bb) > 0) {
                bb.flip();  // después de escribir en el búfer y antes de leer
 //               while (bb.hasRemaining()) {
                    fch2.write(bb);
                      bb.clear(); // volver a escribir
 //               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
