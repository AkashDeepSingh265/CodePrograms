package Tree;

public class CheckBST {

	private boolean isbst(Node root,int[] min,int[] max){
		if(root==null) return true;
		if(root.getLeftChild()==null&&root.getRightChild()==null){
			min[0]=root.getData();
			max[0]=root.getData();
			return true;
		}
		int[] rightmin = new int[1];
		int[] leftmax = new int[1];
		int[] leftmin = new int[1];
		int[] rightmax = new int[1];
		
		boolean isBst =  isbst(root.getLeftChild(),leftmin, leftmax)  && isbst(root.getRightChild(),rightmin, rightmax) && leftmax[0]<root.getData() && root.getData()<rightmin[0];
		min[0] = leftmin[0];
		max[0] = rightmax[0];
		return isBst;
	}
	public static void main(String[] args){
		Tree  bst = new Tree(6);
		bst.createTree();
		CheckBST obj = new CheckBST();
		int[] min = new int[1];
		int[] max = new int[1];
		System.out.println(obj.isbst(bst.getRoot(), min, max));
		
	}
}
