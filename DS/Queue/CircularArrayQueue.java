package Queue;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class CircularArrayQueue<T> {

	protected T[] array;
	protected int capacity;
	protected int front ;
	protected int rear ;
	
	public CircularArrayQueue(Class<T> c , int size){
		capacity = size;
		array = (T[]) Array.newInstance(c,size);
		front = -1;
		rear = -1;
	}
	public boolean isEmptyQueue(){
		return front==-1;
	}
	public boolean isFullQueue(){
		return (rear+1)%capacity == front;
	}
	public void enqueue(T data){
		if(isFullQueue()) throw new NoSuchElementException("OverFLow");
		rear = (rear+1)%capacity;
		array[rear] = data;
		if(front == -1){
			front = rear;
		}
	}
	public T dequeue(){
		T data;
		if(isEmptyQueue()) throw new NoSuchElementException("UnderFlow");
		data = array[front];
		if(front==rear){
			front = rear = -1;
		}else{
			front = (front+1)%capacity;
		}
		return data;
	}
	public void printQueue(){
		if(isEmptyQueue()){
			System.out.println("EmptyQueue");return;
		} 
		int cur = front;
		System.out.println("Printing queue");
		while(cur!=rear){
			System.out.println(array[cur]);
			cur = (cur+1)%capacity;
		}
		System.out.println(array[cur]);
	}
	public static void main(String[] args){
		CircularArrayQueue<Integer> queue= new CircularArrayQueue<>(Integer.class, 5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(6);
		queue.enqueue(7);
		queue.dequeue();
		queue.printQueue();
		
	}
}
