package Heap;

public class MinHeap {
	
	private int[] heap;
	private int maxSize;
	private int size;
	
	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.heap = new int[this.maxSize];
		this.size=0;
	}
	
	public int parent(int pos){
		return (pos-1)/2;
	}
	
	public int leftChild(int pos){
		return 2*pos + 1;
	}
	
	public int rightChild(int pos){
		return 2*pos + 2;
	}
	
	public void insert(int number){
		heap[++size-1] = number;
		int current=size-1;
		while(heap[current] < heap[parent(current)]){
			int temp = heap[parent(current)];
			heap[parent(current)]=heap[current];
			heap[current]=temp;
			current=parent(current);
		}
	}
	
	public int extractMin(){
		int min = heap[0];
		heap[0] = heap[size-- -1];
		heapify(heap, 0, size);
		return min;
	}
	
	public int peek(){
		return heap[0];
	}
	public void buildHeap(int[] array){
		int n = array.length;
		for(int i = n/2 -1; i>=0;i--){
			heapify(array, i, n);
		}
	}
	
	
	private void heapify(int[] array,int pos,int size){
		int currentElement = array[pos];
		int leftChildPos = 2*pos + 1;
		int rightChildPos = 2*pos + 2;
		
		int minElement = currentElement;
		int minPos = pos;
		if(leftChildPos < size && array[leftChildPos] < minElement){
			minElement = array[leftChildPos];
			minPos = leftChildPos;
		}
		
		if(rightChildPos < size && array[rightChildPos] < minElement){
			minElement = array[rightChildPos];
			minPos = rightChildPos;
		}
		if(minPos!=pos){
			int temp = currentElement;
			array[pos]= array[minPos];
			array[minPos] = temp;
			heapify(array, minPos, size);
		}
	}
	
	public static void main(String[] args){
		MinHeap heap = new MinHeap(30);
		heap.insert(5);
		heap.insert(2);
		heap.insert(6);
		System.out.println("CurrentMin:"+heap.peek());
		heap.insert(-1);
		heap.insert(1);
		heap.insert(3);
		System.out.println("CurrentMin:"+heap.peek());
		heap.insert(10);
		heap.insert(-3);
		heap.insert(9);
		System.out.println("CurrentMin:"+heap.peek());
		
	}
}
