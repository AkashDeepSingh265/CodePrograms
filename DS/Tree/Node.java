package Tree;

public class Node {
	private int data;
	private Node left;
	private Node right;
	
	public Node(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setLeftChild(Node left){
		this.left = left;
	}
	public void setRightChild(Node right){
		this.right = right;
	}
	
	public  Node getLeftChild(){
		return this.left;
	}
	public Node getRightChild(){
		return this.right;
	}
	public int getData(){
		return data;
	}
}
