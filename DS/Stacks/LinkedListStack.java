package Stacks;

import java.util.NoSuchElementException;


public class LinkedListStack<T> {

	class Node {
		private T data;
		private Node next;
		
		public Node(){
			next = null;
		}
		public Node(T value){
			data = value;
			next = null;
		}
		public void setData(T value){
			data = value;
		}
		public void setNextNode(Node node){
			next = node;
		}
		public T getData(){
			return data;
		}
		public Node getNext(){
			return next;
		}
	}
	
	private Node top;
	
	public LinkedListStack(){
		top = null;
	}
	
	public void push(T value){
		Node temp = new Node(value);
		if(top==null){
			top = temp;
		}else {
			temp.setNextNode(top);
			top = temp;
		}
	}
	public boolean isEmpty(){
		return top == null;
	}
	public T pop(){
		T data;
		Node temp;
		if(isEmpty()){
			throw new NoSuchElementException("UnderFlow");
		}else {
			data = top.getData();
			temp = top.getNext();
			top.setNextNode(null);
			top = temp;
			return data;
		}
	}
	public T getTop(){
		if(isEmpty()) throw new NoSuchElementException("UnderFlow");
		return top.getData();
	}
	public void printStack(){
		Node temp = top;
		while(temp!=null){
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	
	public static void main(String[] args){
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.printStack();
		stack.pop();
		stack.pop();
		System.out.println("stack:");
		stack.printStack();
	}
}
