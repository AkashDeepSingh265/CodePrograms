package Tree;

import java.util.Stack;

public class IterativePostOrder {

	public static void printIterativePostOrder(Node root){
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		Node prev = null;
		while(!stack.isEmpty()){
			while(stack.peek().getLeftChild()!=null){
				stack.push(stack.peek().getLeftChild());
			}
			
			while(!stack.isEmpty() && (stack.peek().getRightChild()==null || prev==stack.peek().getRightChild())){
				prev = stack.pop();
				System.out.print(prev.getData()+" ");
			}
				
			
			if(!stack.isEmpty()){
				stack.push(stack.peek().getRightChild());
			}
		}
	}
	
	public static void main(String[] args){
		Tree tree = new Tree(10);
		tree.createTestTree();
		printIterativePostOrder(tree.getRoot());
		System.out.println();
		tree.PostOrderTraversal();
		//tree.PostOrderTraversal();
	}
}
