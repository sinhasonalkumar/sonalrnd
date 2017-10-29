package com.sonal.ds.linkedlist;

public class MyLinkedList<T> {

    private Node<T> head;

    public boolean addNodeAtHead(T value) {
	boolean result = false;

	try {
	    Node<T> newNode = new Node<>();
	    newNode.setValue(value);
	    if (head != null) {
		newNode.setNext(head);
	    } 
	    head = newNode;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	result = true;

	return result;
    }

    @Override
    public String toString() {
	StringBuilder nodes = new StringBuilder();
	Node<T> temp = head;
	while (temp != null) {
	    nodes.append(temp.getValue() + "->");
	    temp = temp.getNext();
	}
	nodes.append("NULL");
	return nodes.toString();
    }

}
