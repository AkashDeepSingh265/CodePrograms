package Tree;

import LinkList.DoublyLinkedList;
import LinkList.DoublyLinkedList.DoublyLLNode;

//class to convert Sorted Doubly liked list to bst
public class DoublyLinkedListToBST {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private DoublyLLNode createBstFromLinkList(DoublyLLNode head){
		if(head==null) return null;
		if(head.getNext()==null)return head;
		DoublyLLNode mid = FindMid(head);
		if(mid.getPrev()!=null){
			mid.getPrev().setNextNode(null);
		}
		mid.getNext().setPrevNode(null);
		//to avoid stack overflow
		if(mid!=head){
			mid.setPrevNode(createBstFromLinkList(head));
		}
		mid.setNextNode(createBstFromLinkList(mid.getNext()));
		return mid;
		
	}
	private DoublyLLNode FindMid(DoublyLLNode head) {
		if(head==null) return null;
		if(head.getNext()==null) return head;
		DoublyLLNode slow,fast;
		slow = head;
		fast = head.getNext();
		while(fast!=null){
			fast = fast.getNext();
			if(fast!=null){
				fast = fast.getNext();
				slow = slow.getNext();
			}
		}
		return slow;
	}
	public static void main(String[] args){
		DoublyLinkedListToBST obj = new DoublyLinkedListToBST();
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		Integer[] numbers = {1,2};
		list.createList(numbers);
		DoublyLLNode root = obj.createBstFromLinkList(list.getStart());
		
		
	}
}
