package LinkList;


public class LinkedList<T> {
	public class LLNode {
		private T data;
		private LLNode next;
		
		public LLNode(){
			next = null;
		}
		public LLNode(T value){
			data = value;
			next = null;
		}
		public void setData(T value){
			data = value;
		}
		public void setNextNode(LLNode node){
			next = node;
		}
		public T getData(){
			return data;
		}
		public LLNode getNext(){
			return next;
		}
	}
	private LLNode start;
	private LLNode end;
	public LinkedList(){
		start = null;
		end = null;
	}
	public void add(T value){
		if(start == null){
			start = new LLNode(value);
			end = start;
		}else{
			LLNode temp = new LLNode(value);
			end.setNextNode(temp);
			end = temp;
		}
	}
	
	public void createList(T[] ary){
		for(int i = 0 ; i < ary.length;i++){
			add(ary[i]);
		}
	}
	public void printList(LLNode head){
		LLNode temp = head;
		while(temp!=null){
			System.out.print(temp.getData()+"-->");
			temp = temp.getNext();
		}
		System.out.print("null");
	}
	
	public void printList(){
		LLNode temp = start;
		while(temp!=null){
			System.out.print(temp.getData()+"-->");
			temp = temp.getNext();
		}
		System.out.print("null");
	}
	public LLNode getStart(){
		return start;
	}
	public LLNode getTail(){
		return end;
	}
	public void setStart(LLNode head){
		this.start = head;
	}
}
