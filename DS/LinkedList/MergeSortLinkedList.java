package LinkedList;

public class MergeSortLinkedList {

	public static NodeLL MergeSortLL(NodeLL root){
		if(root.getNext()==null){
			return root;
		}
		NodeLL middle = findMiddleNode(root);
		NodeLL root2 = middle.getNext();
		middle.setNext(null);
		NodeLL head1 = MergeSortLL(root);
		NodeLL head2 = MergeSortLL(root2);
		
		return MergeSortedLinkList(head1,head2);
		
	}
	
	private static NodeLL MergeSortedLinkList(NodeLL head1, NodeLL head2) {
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		
		if(head1.getData().compareTo(head2.getData()) == -1){
			head1.setNext(MergeSortedLinkList(head1.getNext(), head2));
			return head1;
		}else{
			head2.setNext(MergeSortedLinkList(head1, head2.getNext()));
			return head2;
		}
	}

	public static NodeLL findMiddleNode(NodeLL root){
		if(root==null)
			return null;
		if(root.getNext()==null || root.getNext().getNext()==null){
			return root;
		}
		NodeLL slowPointer=root;
		NodeLL fastPointer=root;
		while(fastPointer.getNext()!=null&&fastPointer.getNext().getNext()!=null){
			slowPointer=slowPointer.getNext();
			fastPointer=fastPointer.getNext().getNext();
		}
		return slowPointer;
	}
	public static void main(String[] args){
		//System.out.println(findMiddleNode(LinkedListGenerator.generateLinkedListRandom(7)).getData());
		for(int i = 0 ; i < 5 ; i ++){
			LinkedListGenerator.printLinkedList(MergeSortLL(LinkedListGenerator.generateLinkedListRandom(20)));
			System.out.println("==============================================================================");
		}
		
	}
}
