package LinkList;

import LinkList.LinkedList.LLNode;

public class ReverseInPair {

	private LLNode reversePairs(LLNode head){
		if(head==null||head.getNext()==null){
			return head;
		}
		LLNode temp;
		temp = head;
		head = temp.getNext();
		temp.setNextNode(reversePairs(head.getNext()));
		head.setNextNode(temp);
		return head;
	}
	
	public static void main(String[] args){
		LinkedList<Integer> lst  = new LinkedList<>();
		Integer[] numbers = {1,2,3,4,5,6,7,8};
		lst.createList(numbers);
		ReverseInPair obj = new ReverseInPair();
		LLNode start = obj.reversePairs(lst.getStart());
		lst.printList(start);
		
	}
}
