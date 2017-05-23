package LinkList;

import LinkList.LinkedList.LLNode;

public class ReverseAlternateAppendEnd {
	
	private void reverseAlternate(LLNode head){
		if(head.getNext()==null||head.getNext().getNext()==null) return;
		LLNode odd  = head;
		LLNode even = odd.getNext();
		
		odd.setNextNode(even.getNext());
		odd = even.getNext();
		even.setNextNode(null);
		LLNode temp;
		while(odd!=null&&odd.getNext()!=null&&odd.getNext().getNext()!=null){
			temp = odd.getNext();
			odd.setNextNode(temp.getNext());
			temp.setNextNode(even);
			even = temp;
			odd = odd.getNext();
		}
		while(odd.getNext()!=null){
			odd=odd.getNext();
		}
		odd.setNextNode(even);
	}
	public static void main(String[] args){
		LinkedList<Integer> lst  = new LinkedList<>();
		Integer[] numbers = {1,2,3,4,5,6,7};
		lst.createList(numbers);
		ReverseAlternateAppendEnd obj = new ReverseAlternateAppendEnd();
		obj.reverseAlternate(lst.getStart());
		lst.printList();
		
	}
}
