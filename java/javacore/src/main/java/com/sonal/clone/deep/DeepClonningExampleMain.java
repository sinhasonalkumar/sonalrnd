package com.sonal.clone.deep;


public class DeepClonningExampleMain {

	public static void main(String[] args) {
		DeepClonningExample object = new DeepClonningExample();
		object.setId(1);
		object.setUserName("abc");

		DetailsDTO detailsDTO = new DetailsDTO();
		detailsDTO.setAge(30);
		object.setDetailsDTO(detailsDTO);

		DeepClonningExample clonnedObject = null;
		try {
			clonnedObject = (DeepClonningExample) object.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Original Object :: " + object + " :: HashCode ::  " + object.hashCode());
		System.out.println("Clonned Object :: " + clonnedObject + " :: Hashcode :: " + clonnedObject.hashCode());
		System.out.println("object == clonnedObject :: " + (object == clonnedObject ? "true" : "false"));

		clonnedObject.setUserName("ChangedToXYZ");
		clonnedObject.getDetailsDTO().setAge(20);

		System.out.println("------Clonned Object Altered--------------");

		System.out.println("Original Object :: " + object.getUserName());
		System.out.println("Original Object :: " + object.getDetailsDTO().getAge());
		System.out.println("Clonned Object :: " + clonnedObject.getUserName());
		System.out.println("Clonned Object :: " + clonnedObject.getDetailsDTO().getAge());

		object.setUserName("ChangedToUVW");
		object.getDetailsDTO().setAge(40);

		System.out.println("------Original Object Altered--------------");

		System.out.println("Original Object :: " + object.getUserName());
		System.out.println("Original Object :: " + object.getDetailsDTO().getAge());
		System.out.println("Clonned Object :: " + clonnedObject.getUserName());
		System.out.println("Clonned Object :: " + clonnedObject.getDetailsDTO().getAge());
	}
}
