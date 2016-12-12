package LinkedList;

public class ReverseLinkedList {

	public static NodeLL<Integer> reverse(NodeLL<Integer> root){
		if(root ==null || root.getNext()==null){
			return root;
		}
		NodeLL<Integer> prev = null;
		NodeLL<Integer> current = root;
		NodeLL<Integer> next = null;
		while(current!=null){
			next=current.getNext();
			current.setNext(prev);
			prev=current;
			current=next;
		}
		
		return prev;
	}
	
	public static void main(String[] args){
		LinkedListGenerator.printLinkedList(reverse(LinkedListGenerator.generateLinkedListRandom(10)));
	}
}
