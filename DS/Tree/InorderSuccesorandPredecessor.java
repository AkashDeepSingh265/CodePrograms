package Tree;

public class InorderSuccesorandPredecessor {

	// do inorder treversal and store previous value and when root data becomes equal to data return previous
	public Node findInorderpredecessor(Node root , int data,Node prev ){
		if(root == null) return null;
		Node left = findInorderpredecessor(root.getLeftChild(), data,prev);
		if(left!=null) return left;
		if(root.getData()==data) return prev;
		prev.setData(root.getData());
		Node right = findInorderpredecessor(root.getRightChild(), data,prev);
		if(right!=null)return right;
		return null;
	}
	
	//do inorder treversal and return the node whose data is greater data . Beacause inorder sorts bst . so the first node we find
	//having value more than data is our succesor
	public Node findInorderSuccesor(Node root,int data){
		if(root == null ) return null;
		//if(root.getData()==data) return findMin(root.getRightChild());
		Node left = findInorderSuccesor(root.getLeftChild(), data);
		if(left!=null) return left;
		if(root.getData()>data) return root;
		Node right = findInorderSuccesor(root.getRightChild(), data);
		if(right!=null)return right;
		return null;
	}
//	public Node findInorderSuccesor(Node root,int data){
//		if(root == null ) return null;
//		if(root.getData()==data) return findMin(root.getRightChild());
//		Node left = findInorderSuccesor(root.getLeftChild(), data);
//		if(left!=null) return left;
//		if(root.getData()>data) return root;
//		Node right = findInorderSuccesor(root.getRightChild(), data);
//		if(right!=null)return right;
//		return null;
//	}
	private Node findMin(Node root) {
		if(root==null)return null;
		while(root.getLeftChild()!=null){
			root = root.getLeftChild();
		}
		return root;
	}
	public static void main(String[] args){
		Tree bst = new Tree(6);
		bst.createBinarysearch();
		InorderSuccesorandPredecessor obj = new InorderSuccesorandPredecessor();
		Node prev = new Node(0);
		System.out.println( obj.findInorderpredecessor( bst.getRoot(),7,prev).getData());
	}
}
