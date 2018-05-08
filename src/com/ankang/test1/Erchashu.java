package com.ankang.test1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import org.junit.Test;

public class Erchashu {
	private Node rootNode;

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	public void insertNode(int value){
		Node newNode = new Node(value);
		if(rootNode == null){
			rootNode = newNode;
		}else{
			Node currentNode = rootNode;
			Node parentNode;
			while(true){
				parentNode=currentNode;
				if(value>= currentNode.getValue()){
					currentNode = currentNode.getRightNode();
					if(currentNode == null){
						parentNode.setRightNode(newNode);
						return;
					}
				}else{
					currentNode = currentNode.getLeftNode();
					if(currentNode == null){
						parentNode.setLeftNode(newNode);
						return;
					}
				}
			}
		}
		
	}
	public Node find(int key){
		Node currentNode = rootNode;
		if(currentNode != null){
			while(currentNode.getValue() != key){
				if(key > currentNode.getValue()){
					currentNode=currentNode.getRightNode();
				}else{
					currentNode=currentNode.getLeftNode();
				}
			}
			if(currentNode.isDelete()){
				return null;
			}else{
				return currentNode;
			}
		}
		return null;
	}
	
	public boolean delete(int key){
		Node findNode = this.find(key);
		if(findNode == null){
			return false;
		}else{
			findNode.setDelete(true);
		}
		return true;
	}
	
	public void order(Node rootNode){
		if(rootNode!=null&&!rootNode.isDelete()){
			order(rootNode.getLeftNode());
			System.out.println(rootNode.getValue());
			order(rootNode.getRightNode());
		}
	}
	
	@Test
	public void test(){
		Erchashu er = new Erchashu();
		er.insertNode(20);
		er.insertNode(212);
		er.insertNode(34);
		er.insertNode(56);
		er.insertNode(21);
		er.insertNode(11);
		er.insertNode(16);
		er.insertNode(12);
		ceci(er.getRootNode());
//		ceciR(er.getRootNode());
//		before(er.getRootNode());
//		er.delete(212);
//		er.order(er.find(20));
		
	}
	public void ceci(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(queue.size()!=0){
			int len = queue.size();
			for(int i=0;i<len;i++){
				Node node = queue.poll();
				System.out.print(node.getValue()+",");
				if(node.getLeftNode() != null) queue.add(node.getLeftNode());
				if(node.getRightNode() != null) queue.add(node.getRightNode());
			}
			System.out.println();
		}
	}
	public void ceciR(Node root){
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(queue.size()!=0){
			int len = queue.size();
			for(int i=0;i<len;i++){
				Node node = queue.poll();
				stack.add(node);
				if(node.getRightNode() != null) queue.add(node.getRightNode());
				if(node.getLeftNode() != null) queue.add(node.getLeftNode());
			}
		}
		int stackSize = stack.size();
		for(int i=0;i<stackSize;i++){
			System.out.println(stack.pop().getValue());
		}
	}
	
	public void before(Node root){
		if(root != null){
			System.out.println(root.getValue());
			ceci(root.getLeftNode());
			ceci(root.getRightNode());
		}
	}
	@Test
	public void ceciRe(){
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.add(1);
		deque.add(2);
		deque.add(3);
		deque.add(4);
		int len = deque.size();
		for(int i=0;i<len;i++){
			System.out.println(deque.pollLast());
		}
	}
	
}
