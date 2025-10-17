package com.dam2.ut1.ejemplos.raf;
// RandomAccessFile
/* Crea raf de empleados, con altas y consultas */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
// RAF
public class Raf1 {

    final static int SIZE = 40;
    //static RandomAccessFile raf;
    static Scanner ent;
    public static void main(String[] args) {
	// write your code here
        System.out.println("1. Alta");
        System.out.println("2. Consulta");
        System.out.println("Elige opción:");
        ent = new Scanner(System.in);
        int op = ent.nextInt();
        try (RandomAccessFile raf = new RandomAccessFile("empleados.dat","rw")){
            switch (op)
            {
                case 1: alta(raf);break;
                case 2: consulta(raf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void consulta(RandomAccessFile raf) {
        int id,dept = 0; String nom = null; double salari = 0; // 4 + 4 + 24 + 8 = 40 Bytes
        System.out.println("Id?");
        id = ent.nextInt();
        if (id > 0)
        {
            try {
                raf.seek((id - 1)*SIZE);
                id = raf.readInt();
                nom = raf.readUTF();
                dept = raf.readInt();
                salari = raf.readDouble();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Empleado: " + id + " de nombre " + nom + " departamento " + dept + " y salario " + salari + " euros." );
    }

    private static void alta(RandomAccessFile raf) {
        int id,dept; String nom; double salari; // 4 + 4 + 24 + 8 = 40 Bytes
        System.out.println("Id?");
        id = ent.nextInt();
        ent.nextLine();
        System.out.println("Nombre?");
        nom = ent.nextLine();
        System.out.println("Departamento?");
        dept = ent.nextInt();
        System.out.println("Salario?");
        salari = ent.nextDouble();
        if (id > 0)
        {
            try {
                raf.seek((id - 1)*SIZE);
                raf.writeInt(id);
                nom = nom.substring(0, Math.min(nom.length(), 22));
                //raf.writeUTF(nom);
                // 22 + 2 principi UTF = 24
                raf.writeUTF(String.format("%-22s", nom));
                raf.writeInt(dept);
                raf.writeDouble(salari);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
