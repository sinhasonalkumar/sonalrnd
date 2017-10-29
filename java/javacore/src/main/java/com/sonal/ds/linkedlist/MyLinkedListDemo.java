package com.sonal.ds.linkedlist;

public class MyLinkedListDemo {

    public static void main(String[] args) {
	MyLinkedList<String> myLinkedList = new MyLinkedList<>();
	
	myLinkedList.addNodeAtHead("sonal");
	myLinkedList.addNodeAtHead("kumar");
	myLinkedList.addNodeAtHead("sinha");
	
	System.out.println(myLinkedList);
	

    }
}
