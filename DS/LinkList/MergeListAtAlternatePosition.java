package LinkList;

import LinkList.LinkedList.LLNode;

public class MergeListAtAlternatePosition {

	private void mergeAtAltPosition(LLNode head1 , LLNode head2, LinkedList<Integer> lst2){
		if(head1==null||head2==null){
			lst2.setStart(head2);
			return;
		}
		LLNode temp1;
		LLNode temp2;
		temp1 = head1.getNext();
		temp2 = head2.getNext();
		head1.setNextNode(head2);
		head2.setNextNode(temp1);
		mergeAtAltPosition(temp1, temp2, lst2);
	}
	public static void main(String[] args){
		LinkedList<Integer> lst1  = new LinkedList<>();
		Integer[] numbers = {5,7,17,13,11};
		lst1.createList(numbers);
		LinkedList<Integer> lst2  = new LinkedList<>();
		Integer[] numbers1 = {12,10,2,4,6};
		lst2.createList(numbers1);
		MergeListAtAlternatePosition obj = new MergeListAtAlternatePosition();
		obj.mergeAtAltPosition(lst1.getStart(),lst2.getStart(),lst2);
		lst1.printList();
		System.out.println();
		lst2.printList();
	}
}
