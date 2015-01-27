package com.sonal.clone.shallow;

public class ShallowClonningExampleMain {

	public static void main(String[] args) {
		ShallowClonningExample object = new ShallowClonningExample();
		object.setId(1);
		object.setUserName("abc");

		DetailsVO detailsVO = new DetailsVO();
		detailsVO.setAge(30);
		object.setDetailsVO(detailsVO);

		ShallowClonningExample clonnedObject = null;
		try {
			clonnedObject = (ShallowClonningExample) object.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Original Object :: " + object + " :: HashCode ::  " + object.hashCode());
		System.out.println("Clonned Object :: " + clonnedObject + " :: Hashcode :: " + clonnedObject.hashCode());
		System.out.println("object == clonnedObject :: " + (object == clonnedObject ? "true" : "false"));

		clonnedObject.setUserName("ChangedToXYZ");
		clonnedObject.getDetailsVO().setAge(20);

		System.out.println("------Clonned Object Altered--------------");

		System.out.println("Original Object :: " + object.getUserName());
		System.out.println("Original Object :: " + object.getDetailsVO().getAge());
		System.out.println("Clonned Object :: " + clonnedObject.getUserName());
		System.out.println("Clonned Object :: " + clonnedObject.getDetailsVO().getAge());

		object.setUserName("ChangedToUVW");
		object.getDetailsVO().setAge(40);

		System.out.println("------Original Object Altered--------------");

		System.out.println("Original Object :: " + object.getUserName());
		System.out.println("Original Object :: " + object.getDetailsVO().getAge());
		System.out.println("Clonned Object :: " + clonnedObject.getUserName());
		System.out.println("Clonned Object :: " + clonnedObject.getDetailsVO().getAge());
	}
}
