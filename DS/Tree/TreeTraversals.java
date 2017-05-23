package Tree;

import Stacks.LinkedListStack;

public class TreeTraversals {

	public void iterativePostOrder(Node root){
		LinkedListStack<Node> stack = new LinkedListStack<>();
		while(true){
			while(root!=null){
				stack.push(root);
				root = root.getLeftChild();
			}
			if(stack.isEmpty())break;
			if(stack.getTop().getRightChild()==null){
				root = stack.pop();
				System.out.print(root.getData());
				if(stack.isEmpty())break;
				if(root == stack.getTop().getRightChild()){
					while(root == stack.getTop().getRightChild()){
						System.out.print(stack.getTop().getData());
						root = stack.pop();
						if(stack.isEmpty()){
							root = null;break;	
						}
					}
					root = null;
				}else{
					root = stack.getTop().getRightChild();
				}
			}else{
				root=stack.getTop().getRightChild();
			}
		}
	}
	public void iterativeinorder(Node root){
		LinkedListStack<Node> stack = new LinkedListStack<>();
		while(true){
			while(root!=null){
				stack.push(root);
				root = root.getLeftChild();
			}
			if(stack.isEmpty()) break;
			root = stack.pop();
			System.out.print(root.getData()+" ");
			root = root.getRightChild();
		}
	}
	public static void main(String[] args){
		Tree binaryTree = new Tree(1);
		binaryTree.createTree();
		Node root = binaryTree.getRoot();
		new TreeTraversals().iterativePostOrder(root);
	}
}
