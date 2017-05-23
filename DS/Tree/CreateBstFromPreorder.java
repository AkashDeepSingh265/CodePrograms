package Tree;

public class CreateBstFromPreorder {

	private Node CreateBst(int[] pre,int[] index,int start , int end){
		if(start>end||index[0]>=pre.length) return null;
		Node root = new Node(pre[index[0]]);
		if(start==end){
			index[0]++;return root;
		}
		int greateInd = findGreaterIndex(pre,start,end,pre[index[0]]);
		index[0]++;
		if(greateInd==-1){
			root.setLeftChild(CreateBst(pre, index, start+1,end));
		}else{
			root.setLeftChild(CreateBst(pre, index, start+1,greateInd-1));
			root.setRightChild(CreateBst(pre, index,greateInd,end));
		}
		return root;
	}
	private int findGreaterIndex(int[] pre, int start, int end,int num) {
		for(int i = start;i<=end;i++){
			if(pre[i]>num)return i;
		}
		return -1;
	}
	public static void main(String[] args){
		int[] preorder = {10,7,5,8,9,15,14,13};
		int[] index = {0};
		CreateBstFromPreorder obj = new CreateBstFromPreorder();
		new TreeTraversals().iterativeinorder(obj.CreateBst(preorder, index,0,preorder.length-1));
	}
}
