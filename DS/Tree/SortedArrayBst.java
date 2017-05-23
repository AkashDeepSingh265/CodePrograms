package Tree;
//Given sorted array convert it to bst
public class SortedArrayBst {

	private Node ArrayBst(int[] numbers,int start,int end){
		Node newNode;
		int mid;
		if(start==end){
			newNode = new Node(numbers[start]);
			return newNode;
		}
		if(start<end){
			mid = start + (end-start)/2;
			newNode = new Node(numbers[mid]);
			newNode.setLeftChild(ArrayBst(numbers,start,mid-1));
			newNode.setRightChild(ArrayBst(numbers,mid+1, end));
			return newNode;
		}
		return null;
	}
	
	public static void main(String[] args){
		int[]  numbers = {1,2,3,4,5,6,7};
		SortedArrayBst obj = new SortedArrayBst();
		Node root = obj.ArrayBst(numbers,0,numbers.length-1);
		new TreeTraversals().iterativeinorder(root);
	}
}
