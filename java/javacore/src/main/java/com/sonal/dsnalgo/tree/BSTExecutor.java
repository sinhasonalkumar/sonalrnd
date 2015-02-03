package com.sonal.dsnalgo.tree;

public class BSTExecutor {

	public static void main(String[] args) {
		BinarySearchTreeCustom bst = new BinarySearchTreeCustom();
		bst.add(10);
		bst.add(50);
		bst.add(30);
		bst.add(80);
		bst.add(40);
		bst.add(2);
		System.out.println("Pre-Order Traversing");
		bst.preOrderTraverse(bst);
		
		System.out.println("In-Order Traversing");
		bst.inOrderTraverse(bst);
		
		System.out.println("Post-Order Traversing");
		bst.postOrderTraverse(bst);
		
		
	}
}
