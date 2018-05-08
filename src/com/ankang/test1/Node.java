package com.ankang.test1;

public class Node {
	private Node leftNode;
	private Node rightNode;
	private int value;
	private boolean isDelete = false;
	public Node(Node leftNode,Node rightNode,int value) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.value = value;
	}
	public Node(int value) {
		this(null,null,value);
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
