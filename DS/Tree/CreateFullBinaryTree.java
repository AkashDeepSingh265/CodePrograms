package Tree;
//here full means node can have either 0 or 2 children
public class CreateFullBinaryTree {

	private int findIndex(int[] numbers , int start , int end,int num){
		for(int i = start;i<=end;i++){
			if(numbers[i]==num)return i;
		}
		return -1;
	}
	private Node CreateBinaryTree(int[] pre,int[] post,int[] index,int start,int end){
		if(start>end) return null;
		if(index[0]>=pre.length-1) return null;
		Node root = new Node(pre[index[0]++]);
		if(start == end) return root;
		int postIndex = findIndex(post, start, end,pre[index[0]]);
		root.setLeftChild(CreateBinaryTree(pre, post, index, start,postIndex));
		root.setRightChild(CreateBinaryTree(pre, post, index,postIndex+1, end-1));
		return root;
	}
	public static void main(String[] args){
		int[] pre = {1,2,4,8,9,5,3,6,7};
		int[] post = {8,9,4,5,2,6,7,3,1};
		int[] index = {0};
		CreateFullBinaryTree obj = new CreateFullBinaryTree();
		new TreeTraversals().iterativeinorder(obj.CreateBinaryTree(pre, post,index,0,pre.length-1));
	}
}
