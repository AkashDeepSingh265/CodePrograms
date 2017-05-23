package Tree;

public class FindElement {

	public int findElement(Node node,int value){
		int found;
		if(node!=null){
			if(node.getData()==value){
				return 1;
			}else{
				found = findElement(node.getLeftChild(), value);
				if(found==0){
					return findElement(node.getRightChild(), value);
				}else{
					return found;
				}
			}
		}
		return 0 ;
	}
	public static void main(String[] args){
		Tree binaryTree = new Tree(1);
		binaryTree.createTestTree();
		Node root = binaryTree.getRoot();
		if(new FindElement().findElement(root,7)==1){
			System.out.println("Found");
		}else{
			System.out.println("NotFound");
		}
	}
}
