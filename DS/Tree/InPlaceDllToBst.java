package Tree;

import LinkList.DoublyLinkedList;
import LinkList.DoublyLinkedList.DoublyLLNode;

public class InPlaceDllToBst {
	
	//private static DoublyLLNode CurNOde;
//	public InPlaceDllToBst(DoublyLLNode head){
//		CurNOde = head;
//	}
//	private DoublyLLNode ConvertToBst(int start,int end){
//		if(start > end)return null;
//		int mid = start + (end-start)/2;
//		DoublyLLNode left = ConvertToBst(start,mid-1);
//		DoublyLLNode root = CurNOde;
//		root.setPrevNode(left);
//		CurNOde = CurNOde.getNext();
//		root.setNextNode(ConvertToBst(mid+1, end));
//		return root;
//	}
	private DoublyLLNode ConvertToBst(DoublyLLNode[] node,int start,int end){
		if(start > end)return null;
		int mid = start + (end-start)/2;
		DoublyLLNode left = ConvertToBst(node,start,mid-1);
		DoublyLLNode root = node[0];
		root.setPrevNode(left);
		node[0]=node[0].getNext();
		root.setNextNode(ConvertToBst(node,mid+1, end));
		return root;
	}
	public static void main(String[] args){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		Integer[] numbers = {1,2,3,4,5,6,7};
		list.createList(numbers);
		InPlaceDllToBst obj = new InPlaceDllToBst();
		DoublyLLNode[] ary =  new DoublyLLNode[1];
		ary[0] = list.getStart();
		DoublyLLNode start = obj.ConvertToBst(ary,0,numbers.length-1);
	}
}
