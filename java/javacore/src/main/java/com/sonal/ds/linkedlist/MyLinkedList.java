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

	public Node findNode(Object data) {
		Node currentNode = head.getNode();
		Node foundedNode = null;
		if (currentNode != null) {
			while (currentNode != null) {
				if (currentNode.getData().equals(data)) {
					foundedNode = currentNode;
					break;
				}
				currentNode = currentNode.getNextNode();
			}
		}
		return foundedNode;
	}

	public String removeNode(Object data) {
		String result = null;
		Node currentNode = head.getNode();
		Node previousNode = null;
		Node foundedNode = null;
		if (currentNode != null) {
			while (currentNode != null) {
				if (currentNode.getData().equals(data)) {
					foundedNode = currentNode;
					if (previousNode == null) {
						head.setNode(currentNode.getNextNode());
					} else {
						previousNode.setNextNode(currentNode.getNextNode());
					}
					result = "Removed";
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
		}
		if (foundedNode == null) {
			result = "Not Found !! Can Not Remove ";
		}
		return result;
	}

	public void printAllElements() {
		Node currentnode = head.getNode();

		while (currentnode != null) {
			System.out.println(currentnode.getData());
			currentnode = currentnode.getNextNode();
		}

	}

	public Head getHead() {
		return head;
	}

}
