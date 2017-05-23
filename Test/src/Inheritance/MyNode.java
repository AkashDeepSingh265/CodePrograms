package Inheritance;

 class Node<T> {
	T value ;
	public Node(T value){
		this.value = value;
	}
	public void setValue (T val){
		System.out.println("Node");
		this.value = val;
	}
}

 public class MyNode extends Node<Integer>{

	public MyNode(Integer value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	public void setValue(Integer val){
		System.out.println("Mynode");
		super.setValue(val);
	}
	public static void main(String [] args){
		MyNode mn = new MyNode(3);
		Node n = mn ;
		//n.setValue("abc");
	}
	 
 }