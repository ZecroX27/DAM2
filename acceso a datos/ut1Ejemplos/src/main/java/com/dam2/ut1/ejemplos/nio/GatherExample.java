package com.dam2.ut1.ejemplos.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;

public class GatherExample {
	private static String FILENAME = "ejemplos/temp2.txt";
	public static void main(String[] args) {
		String stream1 = "Recopilando datos del primer búfer";
		String stream2 = "Recopilando datos del segundo búfer";
		ByteBuffer bstream1 = ByteBuffer.wrap(stream1.getBytes());
		ByteBuffer bstream2 = ByteBuffer.wrap(stream2.getBytes());
		// Los siguientes dos búferes guardarán los datos a escribir
		ByteBuffer bLen1 = ByteBuffer.allocate(1024);
		ByteBuffer bLen2 = ByteBuffer.allocate(1024);
		int len1 = stream1.length();
		int len2 = stream2.length();
		// Escribimos la longitud de los datos en los búfers
		bLen1.asIntBuffer().put(len1);
		bLen2.asIntBuffer().put(len2);
		System.out.println("Recopilando: Len1 = " + len1);
		System.out.println("Recopilando : Len2 = " + len2);
		// Escribimos datos al fichero
		try {
			FileOutputStream out = new FileOutputStream(FILENAME);
			GatheringByteChannel gather = out.getChannel();
			gather.write(new ByteBuffer[] {bLen1, bLen2, bstream1, bstream2});
			out.close();
			gather.close();
		}
		catch (FileNotFoundException exObj) {
			exObj.printStackTrace();
		}
		catch(IOException ioObj) {
			ioObj.printStackTrace();
		}
	}
}
