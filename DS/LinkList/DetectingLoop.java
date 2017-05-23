package LinkList;

import LinkList.LinkedList.LLNode;

public class DetectingLoop {

	private boolean hasCycle(LLNode head){
		LLNode slow = head ;
		LLNode fast = head;
		while(slow!=null&&fast!=null){
			fast = fast.getNext();
			if(fast == null) return false;
			if(fast == slow) return true;
			fast = fast.getNext();
			if(fast==slow) return true;
			slow = slow.getNext();
		}
		return false;
	}
	private LLNode getStartOfCycle(LLNode head){
		LLNode slow = head ;
		LLNode fast = head;
		boolean hasloop = false;
		while(slow!=null&&fast!=null){
			fast = fast.getNext();
			if(fast == null){ 
				hasloop = false;break;
			}
			
			if(fast == slow){
				hasloop = true; break;
			}
			fast = fast.getNext();
			if(fast==slow){
				hasloop = true; break;
			}
			slow = slow.getNext();
		}
		if(hasloop){
			int length = 1;
			fast = fast.getNext();
			while(fast!=slow){
				fast = fast.getNext();
				length++;
			}
			slow = head ; 
			fast = head;
			while(length>0){
				fast = fast.getNext();
				length--;
			}
			while(fast!=slow){
				fast = fast.getNext();
				slow = slow.getNext();
			}
			return slow;
		}
		return null;
	}
	public static void main(String[] args){
		LinkedList<Integer> lst  = new LinkedList<>();
		Integer[] numbers = {1,2,3,4,5,6,7,8};
		lst.createList(numbers);
		lst.getTail().setNextNode(lst.getStart().getNext().getNext().getNext().getNext());
		//lst.getTail().setNextNode(lst.getStart());
		DetectingLoop obj = new DetectingLoop();
		System.out.println(obj.getStartOfCycle(lst.getStart()).getData());
	}
}
