package Tree;

import java.util.Arrays;

public class VerticalSum {
	
	private void findVerticalSum(Node root,int[] verticalsum,int hd,int leftMin){
		if(root!=null){
			verticalsum[leftMin+hd]+=root.getData();
			findVerticalSum(root.getLeftChild(), verticalsum, hd-1, leftMin);
			findVerticalSum(root.getRightChild(), verticalsum, hd+1, leftMin);
		}
	}
	private void findMinMax(Node root,int[] minmax,int hd){
		if(root!=null){
			if(hd<minmax[0]){
				minmax[0]=hd;
			}else{
				if(hd>minmax[1]){
					minmax[1]=hd;
				}
			}
			findMinMax(root.getLeftChild(), minmax, hd-1);
			findMinMax(root.getRightChild(), minmax, hd+1);
		}
	}
	public static void main(String[] args){
		int[] minmax = new int[2];//we can use arrays to pass int as reference 
		Tree binarytree = new Tree(1);
		binarytree.createTestTree1();
		VerticalSum obj = new VerticalSum();
		obj.findMinMax(binarytree.getRoot(), minmax,0);
		int[] verticalSum = new int[minmax[1]-minmax[0]+1];
		obj.findVerticalSum(binarytree.getRoot(), verticalSum,0, Math.abs(minmax[0]));
		System.out.println(Arrays.toString(verticalSum));
		
		
		
	}
}
