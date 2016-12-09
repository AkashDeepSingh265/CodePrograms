package LinkedList;

import java.util.Comparator;

public class NodeLL<T extends Comparable<T>> {

	private T data;
	private NodeLL<T> next; 
	
	public void setData(T data){
		this.data = data;
	}
	
	public T getData(){
		return data;
	}
	
	public void setNext(NodeLL<T> next){
		this.next = next;
	}
	public NodeLL<T> getNext(){
		return next;
	}
}
