package com.sonal.dsnalgo.tree.bst;

public class BSTExecutor {

	public static void main(String[] args) {
		//createAddAndTraverseBST();
		compareBSTs();
		
	}

	private static void createAddAndTraverseBST() {
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
	
	
	private static void compareBSTs() {
		BinarySearchTreeCustom bst1 = new BinarySearchTreeCustom();
		bst1.add(10);
		bst1.add(50);
		bst1.add(30);
		bst1.add(80);
		bst1.add(40);
		bst1.add(2);
		
		BinarySearchTreeCustom bst2 = new BinarySearchTreeCustom();
		bst2.add(10);
		bst2.add(50);
		bst2.add(30);
		bst2.add(80);
		bst2.add(40);
		bst2.add(3);
		
		BinarySearchTreeCustom bst3 = new BinarySearchTreeCustom();
		bst3.add(10);
		bst3.add(50);
		bst3.add(30);
		bst3.add(80);
		bst3.add(40);
		bst3.add(2);
		bst3.add(3);
		
		BinarySearchTreeCustom bst4 = new BinarySearchTreeCustom();
		bst4.add(10);
		bst4.add(50);
		bst4.add(30);
		bst4.add(80);
		bst4.add(40);
		bst4.add(2);
		
		System.out.println(bst1.equals(bst2));
		System.out.println(bst1.equals(bst3));
		System.out.println(bst2.equals(bst3));
		System.out.println(bst1.equals(bst4));
		
	}
}
