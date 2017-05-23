package Tree;
//This class find number of nodes with two childrens in binary tree
public class FullNodes {
	private int count(Node root){
		if(root==null){
			return 0;
		}
		if(root.getLeftChild()!=null&&root.getRightChild()!=null){
			return 1 + count(root.getLeftChild())+count(root.getRightChild());
		}else{
			return count(root.getLeftChild()) + count(root.getRightChild());
		}
			
	}
	public static void main(String[] args){
		Tree binary = new Tree(1);
		binary.createTestTree();
		System.out.println(new FullNodes().count(binary.getRoot()));
	}
}
