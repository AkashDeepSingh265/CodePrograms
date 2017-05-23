package Tree;

public class PathSumEqualToNumber {

	private boolean checkSum(Node root,int sum , int value){
		if(root==null) return false;
		sum = sum + root.getData();
		if(sum==value)return true;
		return checkSum(root.getLeftChild(), sum, value) || checkSum(root.getRightChild(), sum, value);
	}
	private void mirror(Node root){
		Node temp;
		if(root!=null){
			temp = root.getLeftChild();
			root.setLeftChild(root.getRightChild());
			root.setRightChild(temp);
			mirror(root.getLeftChild());
			mirror(root.getRightChild());
		}
	}
	public static void main(String[] args){
		Tree binary = new Tree(1);
		binary.createTestTree();
		PathSumEqualToNumber obj = new PathSumEqualToNumber();
		//System.out.println(obj.checkSum(binary.getRoot(),0,4));
		binary.inorderTreversal();
		obj.mirror(binary.getRoot());
		System.out.println();
		binary.inorderTreversal();
	}
}
