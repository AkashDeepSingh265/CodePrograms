package LinkList;

import LinkList.LinkedList.LLNode;

public class ReverseInKblocks {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private LLNode reverseList(LLNode head){
		LLNode prev = null;
		LLNode cur = head;
		LLNode next = null;
		while(cur!=null){
			next = cur.getNext();
			cur.setNextNode(prev);
			prev=cur;
			cur=next;
		}
		return prev;
	}
	@SuppressWarnings("rawtypes")
	private LLNode getKthnode(LLNode head,int k ){
		LLNode temp = head;
		int count = 0;
		while(temp!=null){
			count++;
			if(count==k) return temp;
			temp = temp.getNext();
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private LLNode reverseInK(LLNode head,int k){
		LLNode temp,next;
		LLNode kthNode = getKthnode(head, k); 
		if(kthNode!=null){
			temp = head;
			head = kthNode;
			next = head.getNext();
			head.setNextNode(null);
			head = reverseList(temp);
			temp.setNextNode(reverseInK(next, k));
			return head;
			
		}else{
			return head;
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
			LinkedList<Integer> lst  = new LinkedList<>();
			Integer[] numbers = {1,2,3,4,5,6,7,8};
			lst.createList(numbers);
			ReverseInKblocks obj = new ReverseInKblocks();
			lst.printList(obj.reverseInK(lst.getStart(),3));
			
	}
}
