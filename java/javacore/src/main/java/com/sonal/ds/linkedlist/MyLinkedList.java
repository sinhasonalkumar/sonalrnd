package com.sonal.ds.linkedlist;

public class MyLinkedList {
	
	private Head head;  
	private int size = 0;
		
	public MyLinkedList(){
		head = new Head();
		size = 0;
	}
		
	public void add(Object data){
		Node newNode = new Node();
		Node currentNode = null;
		
		currentNode = findCurrentNode();
		
		currentNode.setData(data);
		currentNode.setNextNode(newNode);
		size++;
	}
	
	private Node findCurrentNode() {
		Node currentNode = head.getNode();
		if(currentNode == null){
			currentNode = new Node();
			head.setNode(currentNode);
		}else{
			for(int i = 0; i< size ; i++){
				currentNode = currentNode.getNextNode();
			}
		}
		
		return currentNode;
	}
	
	public void printAllElements(){
		Node currentnode = head.getNode();
		while(currentnode.getNextNode() != null){
			System.out.println(currentnode.getData());
			currentnode = currentnode.getNextNode();
		}
	}


	public Head getHead() {
		return head;
	}

	public int getSize() {
		return size;
	}
	
	
}
