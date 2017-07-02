package Tree;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Tree {

	private Node root;
	private Scanner in;
	
	private int index;
	public Tree(int data){
		root = new Node(data);
		root.setLeftChild(null);
		root.setRightChild(null);
	}
	
	public Node getRoot(){
		return root;
	}
	public void createBinarysearch(){
		index = -1;
		char[] input = {'y','2','y','1','n','n','y','4','y','3','n','n','y','5','n','n','y','8','y','7','n','n','y','9','n','n'};
		createTestBinaryTree(root,input);
	}
	
	public void createTestTree1(){
		index = -1;
		char[] input = {'y','2','n','y','3','n','n','y','4','y','5','n','n','y','6','y','7','n','n','y','8','n','n'};
		createTestBinaryTree(root,input);
	}
	public void createTestTree(){
		index=-1;
		char[] input = {'y','2','n','y','3','y','4','y','5','y','6','n','n','y','7','n','n','n','y','8','n','y','9','n','n','n'};
		createTestBinaryTree(root,input);
	}
	public void CreateFullBinaryTree(){
		index=-1;
		char[] input = {'y','2','y','4','n','n','y','5','n','n','y','3','y','6','n','n','y','7','n','n'};
		createTestBinaryTree(root,input);
	}
	private void createTestBinaryTree(Node node, char[] input) {
		index ++;
		char choice = input[index];
		if(choice=='y'){
			index=index+1;
			node.setLeftChild(new Node(input[index]-'0'));
	  		createTestBinaryTree(node.getLeftChild(),input);
		}
		index++;
		choice = input[index];
		if(choice=='y'){
			index++;
			node.setRightChild(new Node(input[index]-'0'));
	  		createTestBinaryTree(node.getRightChild(),input);
		}
	}


	private void createBinaryTree(Node node){
	  	String choice;
		System.out.printf("Do yo want to create left Child :Y/N \n");
	  	choice = in.next();
	  	if(choice.equals("y")){
	  		System.out.printf("Enter data Value \n");
	  		node.setLeftChild(new Node(in.nextInt()));
	  		createBinaryTree(node.getLeftChild());
	  	}
	  	System.out.println("Do yo want to create right Child :Y/N ");
	  	choice = in.next();
	  	if(choice.equals("y")){
	  		System.out.println("Enter data Value");
	  		node.setRightChild(new Node(in.nextInt()));
	  		createBinaryTree(node.getRightChild());
	  	}
	  	
	}
	
	public void createTree(){
		in = new Scanner(new InputStreamReader(System.in));
		createBinaryTree(root);
		in.close();
	}
	
	
	public void inorderTreversal(){
		inorder(root);
	}
	
	public void preorderTreversal(){
		System.out.println();
		preorder(root);
	}
	
	public void PostOrderTraversal(){
		System.out.println();
		postorder(root);
	}
	private void postorder(Node node) {
		if(node!=null){
			postorder(node.getLeftChild());
			postorder(node.getRightChild());
			System.out.print(node.getData()+" ");
		}
		
	}


	private void preorder(Node node) {
		if(node!=null){
			System.out.print(node.getData()+" ");
			preorder(node.getLeftChild());
			preorder(node.getRightChild());
		}
	}

	public static void main(String[] args){
		Tree tree = new Tree(10);
		tree.createTestTree();
		tree.inorderTreversal();
	}
	
	private void inorder(Node node) {
		if(node != null){
			inorder(node.getLeftChild());
			System.out.print(node.getData()+" ");
			inorder(node.getRightChild());
		}
	}
}
