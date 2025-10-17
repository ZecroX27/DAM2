package com.dam2.ut1.ejemplos.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Nio5 {
	public static void main(String args[]) throws IOException {
		RandomAccessFile file = new RandomAccessFile("temp.txt", "r");
		FileChannel fileChannel = file.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		while (fileChannel.read(byteBuffer) > 0) {
			// flip the buffer to prepare for get operation
			byteBuffer.flip();
			while (byteBuffer.hasRemaining())
				System.out.print((char) byteBuffer.get());
            // AQUI FALTA ALGO
		}
		file.close();
	}
}
