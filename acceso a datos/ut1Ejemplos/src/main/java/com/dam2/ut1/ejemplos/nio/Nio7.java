package com.dam2.ut1.ejemplos.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Nio7 {
	public static void main(String args[]) throws IOException {
		// añade el contenido al fichero
		writeFileChannel(ByteBuffer.wrap("Welcome to DAM2".getBytes()));
		// lee el fichero
		readFileChannel();
	}
	public static void readFileChannel() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("temp3.txt","r");
		FileChannel fileChannel = randomAccessFile.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		Charset charset = Charset.forName("ISO-8859-15");
		while (fileChannel.read(byteBuffer) > 0) {	// HACE FALTA UN BUCLE ?? DEPENDE DEL TAMAÑO DEL FICHERO Y EL DEL BUFFER
            byteBuffer.flip();			
			System.out.print(charset.decode(byteBuffer));
            byteBuffer.rewind();
		}
		fileChannel.close();
		randomAccessFile.close();
	}
	public static void writeFileChannel(ByteBuffer byteBuffer)throws IOException {
		Set<StandardOpenOption> options = new HashSet<>();
		options.add(StandardOpenOption.CREATE);
		options.add(StandardOpenOption.APPEND);
		Path path = Paths.get("temp3.txt");
		FileChannel fileChannel = FileChannel.open(path, options);
		fileChannel.write(byteBuffer);
		fileChannel.close();
	}
}
