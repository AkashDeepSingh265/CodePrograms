package Tree;

public class CreateTreeFromInorderPreOrder {
	private int index=-1;
	
	private Node constructTree(int[] inorder,int[] preorder,int start,int end){
		if(start<=end){
			index++;
			int curValue = preorder[index];
			Node Cur = new Node(curValue);
			if(start==end)return Cur;
			int index = search(inorder,curValue,start,end);
			if(index==-1){
				System.out.println("Element not found in inorder");
				return null;
			}
			Cur.setLeftChild(constructTree(inorder, preorder, start,index-1));
			Cur.setRightChild(constructTree(inorder, preorder,index+1,end));
			return Cur;
		}
		return null;
	}
	
	private void inorder(Node root){
		if(root!=null){
			inorder(root.getLeftChild());
			System.out.print(root.getData());
			inorder(root.getRightChild());
		}
	}
	private int search(int[] inorder, int curValue, int start, int end) {
		for(int i=start;i<=end;i++){
			if(inorder[i]==curValue)return i;
		}
		return -1;
	}

	public static void main(String[] args){
		int[] inorder = {4,2,5,1,6,3,7};
		int[] preorder = {1,2,4,5,3,6,7};
		CreateTreeFromInorderPreOrder obj = new CreateTreeFromInorderPreOrder();
		Node root = obj.constructTree(inorder, preorder,0,inorder.length-1);
		obj.inorder(root);
		
	}
}
