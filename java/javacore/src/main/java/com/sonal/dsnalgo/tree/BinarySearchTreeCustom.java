package com.sonal.dsnalgo.tree;

public class BinarySearchTreeCustom {

	private TreeNode rootNode;

	public BinarySearchTreeCustom() {
		rootNode = null;
	}

	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public void add(int value) {
		TreeNode nodeToAdd = new TreeNode(value);
		TreeNode currentRootNode = null;
		if (rootNode == null) {
			rootNode = nodeToAdd;
		} else {
			currentRootNode = rootNode;
			addNewNode(currentRootNode, nodeToAdd);
		}
	}

	private void addNewNode(TreeNode currentRootNode, TreeNode nodeToAdd) {
		if (nodeToAdd.getData() < currentRootNode.getData()) {
			if (currentRootNode.getLeftNode() == null) {
				currentRootNode.setLeftNode(nodeToAdd);
			} else {
				currentRootNode = currentRootNode.getLeftNode();
				addNewNode(currentRootNode, nodeToAdd);
			}
		} else {
			if (currentRootNode.getRightNode() == null) {
				currentRootNode.setRightNode(nodeToAdd);
			} else {
				currentRootNode = currentRootNode.getRightNode();
				addNewNode(currentRootNode, nodeToAdd);
			}
		}
	}

	public void preOrderTraverse(BinarySearchTreeCustom bst) {
		TreeNode bstRootNode = bst.getRootNode();
		TreeNode currentRootNode = bstRootNode;
		if (bstRootNode == null) {
			System.out.println("Provided Binary Search Tree Is Empty");
		} else {
			traverseRootLeftRight(currentRootNode);
		}
		System.out.println("\n");
	}

	public void inOrderTraverse(BinarySearchTreeCustom bst) {
		TreeNode bstRootNode = bst.getRootNode();
		TreeNode currentRootNode = bstRootNode;
		if (bstRootNode == null) {
			System.out.println("Provided Binary Search Tree Is Empty");
		} else {
			traverseLeftRootRight(currentRootNode);
		}
		System.out.println("\n");
	}

	public void postOrderTraverse(BinarySearchTreeCustom bst) {
		TreeNode bstRootNode = bst.getRootNode();
		TreeNode currentRootNode = bstRootNode;
		if (bstRootNode == null) {
			System.out.println("Provided Binary Search Tree Is Empty");
		} else {
			traverseLeftRightRoot(currentRootNode);
		}
		System.out.println("\n");
	}

	private void traverseRootLeftRight(TreeNode currentRootNode) {
		if (currentRootNode == null) {
			return;
		}
		System.out.print(currentRootNode.getData() + "\t");
		traverseRootLeftRight(currentRootNode.getLeftNode());
		traverseRootLeftRight(currentRootNode.getRightNode());
	}

	private void traverseLeftRootRight(TreeNode currentRootNode) {
		if (currentRootNode == null) {
			return;
		}
		traverseLeftRootRight(currentRootNode.getLeftNode());
		System.out.print(currentRootNode.getData() + "\t");
		traverseLeftRootRight(currentRootNode.getRightNode());
	}

	private void traverseLeftRightRoot(TreeNode currentRootNode) {
		if (currentRootNode == null) {
			return;
		}
		traverseLeftRightRoot(currentRootNode.getLeftNode());
		traverseLeftRightRoot(currentRootNode.getRightNode());
		System.out.print(currentRootNode.getData() + "\t");
	}

}
