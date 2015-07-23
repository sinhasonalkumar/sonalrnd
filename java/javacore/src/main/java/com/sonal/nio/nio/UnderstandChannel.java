package com.sonal.nio.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class UnderstandChannel {

    public static void main(String[] args) throws IOException {
	
	FileInputStream inputStream = null;
	FileOutputStream outputStream = null;
	long transferTo;
	try {
	    File inputFile = new File("/Users/sonal/sonal/gitlocalrepository/java/javacore/src/main/java/com/sonal/nio/nio/testFile.txt");
	    inputStream = new FileInputStream(inputFile);
	    FileChannel inputFilechannel = inputStream.getChannel();
	    
	    File outputFile = new File("/Users/sonal/sonal/gitlocalrepository/java/javacore/src/main/java/com/sonal/nio/nio/copyTestFile.txt");
	    outputStream = new FileOutputStream(outputFile);
	    FileChannel outputChannel = outputStream.getChannel();
	    
	    long position = 0;
	    long count = inputFilechannel.size();
	    
	    transferTo = inputFilechannel.transferTo(position, count, outputChannel);
	} finally {
	    try {
		if(outputStream != null){
		outputStream.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		if(inputStream != null){
		inputStream.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	
	System.out.println("File Size Copied :: " + transferTo);
	
    }
}
