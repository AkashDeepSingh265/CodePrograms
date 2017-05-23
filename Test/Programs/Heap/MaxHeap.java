package Heap;

public class MaxHeap<T extends Comparable<T>> extends Heap {

	public MaxHeap(T[] ary) {
		super(ary);
	}
	
	public T getMaxELement(){
		if(array.length==0)return null;
		return (T) array[0];
	}
	public void heapifyElement(int i){
		int left = leftChild(i);
		int right = rightChild(i);
		int max;
		if(left!=-1 && array[left].compareTo(array[i])==1 ){
			max = left;
		}else{
			max = i;
		}
		if(right!=-1 && array[right].compareTo(array[max])==1){
			max = right;
		}
		if(max!=i){
			T temp = (T) array[i];
			array[i]=array[max];
			array[max]=temp;
			heapifyElement(max);
		}
		
	}
	public void buildHeap(){
		int n = array.length;
		if(n<=1)return;
		for(int i = (n-1)/2;i>=0;i--){
			heapifyElement(i);
		}
	}
	public static void main(String[] args){
		Integer[] ary = {15,19,10,7,17,16,13,14,21,5,11,70 };
		MaxHeap<Integer> heap = new MaxHeap<Integer>(ary);
		heap.sort();
		heap.printArray();
	}
}
