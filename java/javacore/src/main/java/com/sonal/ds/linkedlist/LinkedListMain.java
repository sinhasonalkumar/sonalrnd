package com.sonal.ds.linkedlist;

public class LinkedListMain {

	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		
		linkedList.add("sonal");
		linkedList.add("kumar");
		linkedList.add("sinha");
		
		linkedList.printAllElements();
		
		Node findNode = linkedList.findNode("kumar");
		System.out.println(findNode != null ? "Found !!" : "Not Found !!");
		
		findNode = linkedList.findNode("abc");
		System.out.println(findNode != null ? "Found !!" : "Not Found !!");
		
		//System.out.println(linkedList.removeNode("sonal"));
		System.out.println(linkedList.removeNode("kumar"));
		//System.out.println(linkedList.removeNode("sinha"));
		
		linkedList.printAllElements();
		
	}
}
