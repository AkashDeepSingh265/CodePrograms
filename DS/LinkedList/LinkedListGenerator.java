package LinkedList;

import java.util.Random;

public class LinkedListGenerator {

	public static NodeLL generateLinkedList(){
		int[] array = {2,5,6,1,4,8,3,10,16,11,7,9};
		NodeLL<Integer> root = null;
		NodeLL<Integer> current = null;
		NodeLL<Integer> prev = null;
		for(int i:array){
			current = new NodeLL<Integer>();
			current.setData(i);
			current.setNext(null);
			if(prev!=null){
				prev.setNext(current);
				prev=current;
			}else{
				prev=current;
			}
			if(root == null){
				root=current;
			}
		}
		printLinkedList(root);
		return root;
	}
	
	public static NodeLL generateLinkedListRandom(int length){
		int[] array = new int[length];
		Random random = new Random();
		for(int i = 0;i<length;i++){
			array[i] = random.nextInt(100);
		}
		NodeLL<Integer> root = null;
		NodeLL<Integer> current = null;
		NodeLL<Integer> prev = null;
		for(int i:array){
			current = new NodeLL<Integer>();
			current.setData(i);
			current.setNext(null);
			if(prev!=null){
				prev.setNext(current);
				prev=current;
			}else{
				prev=current;
			}
			if(root == null){
				root=current;
			}
		}
		printLinkedList(root);
		return root;
	}
	
	public static void printLinkedList(NodeLL root){
		NodeLL current = root;
		while(current!=null){
			System.out.print(current.getData()+"-->");
			current=current.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		generateLinkedListRandom(15);
	}
}
