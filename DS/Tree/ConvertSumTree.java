package Tree;

public class ConvertSumTree {

	private int convertToSumTree(Node root){
		if(root!=null){
			int old = root.getData();
			int value = convertToSumTree(root.getLeftChild()) + convertToSumTree(root.getRightChild());
			root.setData(value);
			return value + old;
		}
		return 0;
	}
	
	public static void main(String[] args){
		Tree binary = new Tree(1);
		binary.createTestTree();
		ConvertSumTree obj = new ConvertSumTree();
		obj.convertToSumTree(binary.getRoot());
		binary.inorderTreversal();
	}
}
