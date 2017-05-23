package Tree;

import java.util.ArrayList;

public class LowestCommonAncestor {

	
	
	
	
	private Node findLCA(Node root,int node1,int node2){
		Node left,right;
		if(root==null)return null;
		if(root.getData()==node1||root.getData()==node2){
			return root;
		}
		
		left = findLCA(root.getLeftChild(), node1, node2);
		right = findLCA(root.getRightChild(), node1, node2);
		if(left!=null&&right!=null) return root;
		return (left!=null ? left : right);
	}
	public static void main(String[] args){
		Tree tr = new Tree(1);
		tr.createTestTree();
		System.out.println(new LowestCommonAncestor().findLCA(tr.getRoot(),5,8).getData());
	}
}
