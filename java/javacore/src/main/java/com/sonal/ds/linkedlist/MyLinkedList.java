package com.sonal.ds.linkedlist;

public class MyLinkedList {

	private Head head;

	public MyLinkedList() {
		head = new Head();
	}

	public void add(Object data) {
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNextNode(null);

		Node currentNode = findCurrentNode();

		if (currentNode == null) {
			head.setNode(newNode);
		} else {
			currentNode.setNextNode(newNode);
		}
	}

	private Node findCurrentNode() {
		Node currentNode = head.getNode();
		if (currentNode != null) {
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
		}
		return currentNode;
	}

	public void printAllElements() {
		Node currentnode = head.getNode();

		while(currentnode != null){
			System.out.println(currentnode.getData());
			currentnode = currentnode.getNextNode();
		}

	}

	public Head getHead() {
		return head;
	}

}
