package Tree;

import java.util.Stack;

public class IterativeInOrder {

	public static void printIterativeInOder(Node root){
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			while(stack.peek().getLeftChild()!=null){
				stack.push(stack.peek().getLeftChild());
			}
			
			while(!stack.isEmpty() && stack.peek().getRightChild()==null)
				System.out.print(stack.pop().getData());
			
			if(!stack.isEmpty()){
				System.out.print(stack.peek().getData());
				stack.push(stack.pop().getRightChild());
			}
		}
	}
	
	public static void main(String[] args){
		Tree tree = new Tree(10);
		tree.createTestTree();
		printIterativeInOder(tree.getRoot());
		System.out.println();
		tree.inorderTreversal();
	}
}
