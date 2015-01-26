package com.sonal.serialization.externalizable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableExampleMain {

	public static void main(String[] args) {
		serialize();
		deSerialize();
	}

	private static void serialize() {
		ExternalizableExample externalizableExample = new ExternalizableExample();
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("ExternalizableExample.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(externalizableExample);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Serialized !!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void deSerialize() {
		ExternalizableExample externalizableExample = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("ExternalizableExample.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			externalizableExample = (ExternalizableExample) objectInputStream.readObject();
			System.out.println("De-Serialized !!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
