package com.sonal.dsnalgo.tree.btree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
	// Node btree = buildBTree();
	Node btree = null;
	btree = addNode(btree, 31);
	btree = addNode(btree, 14);
	btree = addNode(btree, 25);
	btree = addNode(btree, 30);
	traverseBTree(btree);
    }

    public static Node buildBTree() {
	Node bTree = new Node();
	bTree.setValue(10);

	Node leftNode = new Node();
	leftNode.setValue(15);

	Node rightNode = new Node();
	rightNode.setValue(20);

	bTree.setLeftNode(leftNode);
	bTree.setRightNode(rightNode);

	return bTree;
    }

    public static Node addNode(Node btree, int value) {
	if (btree != null) {
	    Node newNode = new Node();
	    newNode.setValue(value);
	    if (value < btree.getValue()) {
		if (btree.getLeftNode() == null) {
		    btree.setLeftNode(newNode);
		} else {
		    addNode(btree.getLeftNode(), value);
		}

	    } else {
		if (btree.getRightNode() == null) {
		    btree.setRightNode(newNode);
		} else {
		    addNode(btree.getRightNode(), value);
		}
	    }

	} else {
	    btree = new Node();
	    btree.setValue(value);
	}

	return btree;
    }

    public static void traverseBTree(Node btree) {

	if (btree != null) {
	    System.out.println(btree.getValue());
	    if (btree.getLeftNode() != null) {
		if (btree.getRightNode() != null) {
		    traverseBTree(btree.getLeftNode());
		    traverseBTree(btree.getRightNode());
		} else {
		    traverseBTree(btree.getLeftNode());
		}
	    } else {
		if (btree.getRightNode() != null) {
		    traverseBTree(btree.getLeftNode());
		    traverseBTree(btree.getRightNode());
		}
	    }

	}
    }
}
