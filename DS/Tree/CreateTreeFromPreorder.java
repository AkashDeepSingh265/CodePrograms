package Tree;


public class CreateTreeFromPreorder {
	private Node constructTree(char[] preorder,int[] index){
		if(index[0]>preorder.length-1) return null;
		Node newNode = new Node(preorder[index[0]]);
		if(preorder[index[0]]=='L'){
			return newNode;
		}else{
			index[0]++;
			newNode.setLeftChild(constructTree(preorder, index));
			index[0]++;
			newNode.setRightChild(constructTree(preorder, index));
			return newNode;
		}
		
	}
	public static void main(String[] args){
	
		char[] preorder={'I','I','I','L','L','I','L','L','I','L','L'};
		int[] index = new int[1];
		Node root = new CreateTreeFromPreorder().constructTree(preorder, index);
		new TreeTraversals().iterativeinorder(root);
	}
}
