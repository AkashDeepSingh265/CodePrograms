package Queue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynamicArrayQueue<T> extends CircularArrayQueue<T> {
	
	Class<T> classType;
	
	public DynamicArrayQueue(Class<T> c){
		this(c,1);
		this.classType = c;
	}
	public DynamicArrayQueue(Class<T> c, int size) {
		super(c, size);
	}
	
	public void enqueue(T data){
		if(isFullQueue()) {
			resizequeue();
		}
		rear = (rear+1)%capacity;
		array[rear] = data;
		if(front == -1){
			front = rear;
		}
	}

	private void resizequeue() {
		int size = capacity;
		capacity = capacity *2;
		T[] newArray = (T[]) Array.newInstance(classType,capacity);
		for(int i = 0 ; i < array.length;i++){
			newArray[i] = array[i];
		}
		array = newArray;
		if(front>rear){
			for(int i = 0 ; i <=rear;i++){
				array[i+size] = array[i];
			}
			rear = rear + size;
		}
	}
	public static void main(String[] args){
		DynamicArrayQueue<Integer> dynqueue = new DynamicArrayQueue<>(Integer.class);
		dynqueue.enqueue(1);
		dynqueue.enqueue(2);
		dynqueue.enqueue(3);
		dynqueue.enqueue(4);
		dynqueue.dequeue();
		dynqueue.dequeue();
		dynqueue.printQueue();
		dynqueue.enqueue(5);
		dynqueue.enqueue(6);
		dynqueue.enqueue(7);
		dynqueue.enqueue(8);
		dynqueue.printQueue();
		
		
	}
}
