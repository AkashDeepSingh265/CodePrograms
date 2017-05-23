package Heap;

import java.util.Arrays;


public abstract class Heap<T extends Comparable<T>> {
	T[] array;
	int count;
	public Heap(T[] ary){
		this.array = ary;
		this.count = ary.length;
	}
	public int parent(int i ){
		if(i<=0||i>=array.length){
			return -1;
		}
		return (i-1)/2;
	}
	public int leftChild(int i ){
		int left = 2*i+1;
		if(left>=this.count){
			return -1;
		}
		return left;
	}
	public int rightChild(int i){
		int right = 2*i+2;
		if(right>=this.count){
			return -1;
		}
		return right;
	}
	public abstract void heapifyElement(int i);
	public abstract void buildHeap();
	public void printArray(){
		System.out.println(Arrays.toString(array));
	}
	public void sort(){
		buildHeap();
		int count = this.count;
		for(int i=0;i<count;i++){
			T temp = array[0];
			array[0]=array[this.count-1];
			array[this.count-1] = temp;
			this.count--;
			heapifyElement(0);
		}
		this.count = count;
	}
}
