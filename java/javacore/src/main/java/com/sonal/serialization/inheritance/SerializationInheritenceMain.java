package com.sonal.serialization.inheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationInheritenceMain {

	public static void main(String[] args) {
		serialize();
		deSerialize();
	}

	private static void serialize() {
		try {
			SerializationInheritence serializationInheritence = new SerializationInheritence();
			FileOutputStream fileOutputStream = new FileOutputStream("SerializationInheritence.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(serializationInheritence);
			
			objectOutputStream.close();
			fileOutputStream.close();
			
			System.out.println("Serialize Works !!");
		} catch (IOException e) {
			System.out.println("Not Worked !!");
			e.printStackTrace();
		}
	}
	
	private static void deSerialize() {
		try {
			SerializationInheritence serializationInheritence = null;
			FileInputStream fileInputStream = new FileInputStream("SerializationInheritence.ser");
			ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);
			
			serializationInheritence = (SerializationInheritence) objectOutputStream.readObject();
			
			objectOutputStream.close();
			fileInputStream.close();
			
			System.out.println("De-SerializeWorks !!");
		} catch (IOException e) {
			System.out.println("Not Worked !!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
