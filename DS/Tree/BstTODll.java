package Tree;

//class to convert BST to circular doubly linked list
public class BstTODll {

	private Node BstDll(Node root){
		if(root==null) return null;
		if(root.getLeftChild()==null&&root.getRightChild()==null){
			return root;
		}
		Node startListleft =null ;
		Node endLsitleft = null;
		Node startListRight = null;
		Node endListRight = null;
		startListleft = BstDll(root.getLeftChild());
		Node temp = startListleft;
		if(temp!=null){
			while(temp.getRightChild()!=null&&temp.getRightChild()!=startListleft){
				temp = temp.getRightChild();
			}
		}
		endLsitleft=temp;
		startListRight = BstDll(root.getRightChild());
		temp = startListRight;
		if(temp!=null){
			while(temp.getRightChild()!=null&&temp.getRightChild()!=startListRight){
				temp = temp.getRightChild();
			}
		}
		endListRight = temp;
		if(startListleft==null||startListRight==null){
			if(startListleft==null){
				root.setLeftChild(endListRight);
				root.setRightChild(startListRight);
				startListRight.setLeftChild(root);
				endListRight.setRightChild(root);
				return root;
			}
			if(startListRight==null){
				root.setLeftChild(endLsitleft);
				root.setRightChild(startListleft);
				startListleft.setLeftChild(root);
				endLsitleft.setRightChild(root);
				return startListleft;
			}
			
		}
			root.setLeftChild(endLsitleft);
			root.setRightChild(startListRight);
			endLsitleft.setRightChild(root);
			startListRight.setLeftChild(root);
			startListleft.setLeftChild(endListRight);
			endListRight.setRightChild(startListleft);
			return startListleft;
	}
	private void printList(Node start){
		Node temp = start;
		while(temp.getRightChild()!=start){
			System.out.print(temp.getData());
			temp = temp.getRightChild();
		}
		System.out.print(temp.getData());
	}
	public static void main(String[] args) {
		Tree binary = new Tree(1);
		binary.createTestTree1();
		Node start = null;
		BstTODll obj =	new BstTODll();
		start = obj.BstDll(binary.getRoot());
		obj.printList(start);
	}

}
