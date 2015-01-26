package com.sonal.serialization.refrencecase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RefrenceSerialzableCaseMain {

	public static void main(String[] args) {

		try {
			SerializeClassA serializeClassA = new SerializeClassA();
			NonSerialzableClass nonSerialzableClass = new NonSerialzableClass();
			serializeClassA.setNonSerialzableClass(nonSerialzableClass);
			
			FileOutputStream fileOutputStream = new FileOutputStream("SerializeClassA.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(serializeClassA);
			System.out.println("Success !!");
			
		} catch (FileNotFoundException ex) {
			System.out.println("Failed !!");
			ex.printStackTrace();
		} catch (IOException e) {
			System.out.println("Failed !!");
			e.printStackTrace();
		}
	}
}
