package LinkList;

import LinkList.LinkedList.LLNode;

public class MergeSortLinkedList {

	
	private LLNode mergeSort(LLNode head){
		if(head==null||head.getNext()==null) return head;
		LLNode a =head;
		LLNode b = splitListMid(head);
		a=mergeSort(a);
		b=mergeSort(b);
		return mergelist(a,b);
		
	}
	private LLNode mergelist(LLNode a, LLNode b) {
		if(a==null)return b;
		if(b==null) return a;
		LLNode result;
		if((int)a.getData()<=(int)b.getData()){
			result = a;
			result.setNextNode(mergelist(a.getNext(), b));
		}else{
			result = b;
			result.setNextNode(mergelist(a, b.getNext()));
		}
		return result;
	}
	private LLNode splitListMid(LLNode head) {
		if(head==null||head.getNext()==null)return head;
		LLNode slow = head;
		LLNode fast = head;
		while(fast.getNext()!=null&&fast.getNext().getNext()!=null){
			fast = fast.getNext().getNext();
			slow=slow.getNext();
		}
		LLNode temp = slow.getNext();
		slow.setNextNode(null);
		return temp;
	}
	public static void main(String[] args){
		LinkedList<Integer> lst1  = new LinkedList<>();
		Integer[] numbers = {10,9,8,7,6,5,4,3,2,1};
		lst1.createList(numbers);
		lst1.setStart(new MergeSortLinkedList().mergeSort(lst1.getStart()));
		lst1.printList();
	}
}
