package com.sonal.serialization.serialversionid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExampleDTOMain {

	public static void main(String[] args) {
		//serialize();
		deSerialize();
	}

	

	private static void serialize() {
		ExampleDTO exampleDTO = new ExampleDTO();
		exampleDTO.setId(1);
		exampleDTO.setUserName("abc");
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("ExampleDTO.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(exampleDTO);
			
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Seralized !!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void deSerialize() {
		ExampleDTO exampleDTO = null;
		
		try {
			FileInputStream fileInputStream = new FileInputStream("ExampleDTO.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			exampleDTO = (ExampleDTO) objectInputStream.readObject();
			System.out.println("De-Seralized !!");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
