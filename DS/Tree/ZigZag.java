package Tree;

import Queue.CircularArrayQueue;
import Stacks.LinkedListStack;

public class ZigZag {

	private void printZigZag(Node root){
		CircularArrayQueue<Node> queue = new CircularArrayQueue<>(Node.class,12);
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		int level = 1;
		Node temp;
		queue.enqueue(root);
		queue.enqueue(null);
		while(!queue.isEmptyQueue()){
			temp = queue.dequeue();
			if(temp==null){
				if(level%2==0){
					while(!stack.isEmpty()){
						System.out.print(stack.pop());
					}
				}
				if(!queue.isEmptyQueue()){
					queue.enqueue(null);
				}
				level++;
			}else{
				if(level%2==1){
					System.out.print(temp.getData());
					if(temp.getLeftChild()!=null){
						queue.enqueue(temp.getLeftChild());
					}
					if(temp.getRightChild()!=null){
						queue.enqueue(temp.getRightChild());
					}
				}else{
					if(temp.getLeftChild()!=null){
						queue.enqueue(temp.getLeftChild());
					}
					if(temp.getRightChild()!=null){
						queue.enqueue(temp.getRightChild());
					}
					stack.push(temp.getData());
				}
			}
		}
	}
	public static void main(String[] args){
		Tree binarytree = new Tree(1);
		binarytree.createTestTree();
		ZigZag obj = new ZigZag();
		obj.printZigZag(binarytree.getRoot());
	}
}
