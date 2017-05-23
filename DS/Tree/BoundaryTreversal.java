package Tree;

public class BoundaryTreversal {

	private void BoundaryOrderTreversal(Node root){
		if(root==null) return;
		System.out.print(root.getData()+" ");
		printLeftPreorder(root.getLeftChild());
		printLeaves(root.getLeftChild());
		printRightPostOrder(root.getRightChild());
		printLeaves(root.getRightChild());
	}
	private void printLeaves(Node root) {
		if(root==null)return;
		if(leaf(root)){
			System.out.print(root.getData()+" ");
			return;
		}
		printLeaves(root.getLeftChild());
		printLeaves(root.getRightChild());
	}
	private void printRightPostOrder(Node root) {
		if(root==null)return;
		if(root.getRightChild()!=null){
			printRightPostOrder(root.getRightChild());
			System.out.print(root.getData()+" ");
		}else{
			if(root.getLeftChild()!=null){
				printRightPostOrder(root.getLeftChild());
				System.out.print(root.getData()+" ");
			}
		}
	}
	private void printLeftPreorder(Node root) {
		if(root==null)return;
		if(root.getLeftChild()!=null){
			System.out.print(root.getData()+" ");
			printLeftPreorder(root.getLeftChild());
		}else{
			if(root.getRightChild()!=null){
				System.out.print(root.getData()+" ");
				printLeftPreorder(root.getRightChild());
			}
		}
	}
	private boolean leaf(Node root) {
		if(root.getLeftChild()==null&&root.getRightChild()==null)return true;
		return false;
	}
	public static void main(String[] args){
		Tree binary = new Tree(20);
		binary.createTree();
		BoundaryTreversal obj = new BoundaryTreversal();
		obj.BoundaryOrderTreversal(binary.getRoot());
	}
}
