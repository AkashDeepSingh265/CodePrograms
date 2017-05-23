package LinkList;


public class DoublyLinkedList<T> {

	public class DoublyLLNode {
		private T data;
		private DoublyLLNode next;
		private DoublyLLNode prev;
		
		public DoublyLLNode(){
			next = null;
			prev = null;
		}
		public DoublyLLNode(T value){
			data = value;
			next = null;
			prev=null;
		}
		public void setData(T value){
			data = value;
		}
		public void setNextNode(DoublyLLNode node){
			next = node;
		}
		public void setPrevNode(DoublyLLNode node){
			prev = node;
		}
		public T getData(){
			return data;
		}
		public DoublyLLNode getNext(){
			return next;
		}
		public DoublyLLNode getPrev(){
			return prev;
		}
	}
	
	private DoublyLLNode last;
	private DoublyLLNode start;
	public DoublyLinkedList(){
		last = null;
		start = null;
	}
	public void add(T value){
		if(last == null){
			start = new DoublyLLNode(value);
			last = start;
		}else{
			DoublyLLNode temp = new DoublyLLNode(value);
			last.setNextNode(temp);
			temp.setPrevNode(last);
			last = temp;
		}
	}
	public void createList(T[] ary){
		for(int i = 0 ; i < ary.length;i++){
			add(ary[i]);
		}
	}
	public void printList(){
		DoublyLLNode temp = start;
		while(temp!=null){
			System.out.print(temp.getData()+"-->");
			temp = temp.getNext();
		}
		System.out.print("null");
	}
	public DoublyLLNode getStart(){
		return start;
	}
	
	public static void main(String[] args){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		Integer[] ary = {2,3,4,5,6,7,8};
		list.createList(ary);
		list.printList();
	}
}
