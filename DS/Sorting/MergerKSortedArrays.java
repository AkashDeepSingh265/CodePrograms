package Sorting;

import java.util.Arrays;

public class MergerKSortedArrays {

	private int[] lastIndex;
	private int[] helper;
	private int[][] ary = {{1,3,5,7},
			{2,4,6},{15,16,17},
			{0,9,12,14,18},
			{8,10}
	};
	
	private void compute(){
		int n=17;
		int result[] = new int[n];
		helper = new int[n];
		int k=0;
		for(int i=0;i<ary.length;i++){
			for(int j=0;j<ary[i].length;j++){
				result[k]=ary[i][j];
				k++;
			}
		}
		int numberofarrys = ary.length;
		lastIndex = new int[numberofarrys] ;
		int cur = -1;
		for(int i=0;i<numberofarrys;i++){
			cur = cur+ary[i].length;
			lastIndex[i]=cur;
		}
		mergeArrays(result,0,numberofarrys-1);
		System.out.println(Arrays.toString(result));
	}
	private void mergeArrays(int[] result, int start, int end) {
		int mid;
		if(start<end){
			mid = (start + end)/2;
			mergeArrays(result, start,mid);
			mergeArrays(result,mid+1, end);
			merge(result,start,mid,end);
		}
	}
	private void merge(int[] result, int st, int m, int en) {
		int start = lastIndex[st]-ary[st].length+1;
		int mid = lastIndex[m];
		int end = lastIndex[en];
		for(int i=start;i<=end;i++){
			helper[i] = result[i];
		}
		int i = start;              
		int j = mid+1;
		int k=start;
		
		while(i<=mid&&j<=end){
			if(helper[i]<helper[j]){
				result[k]=helper[i];
				i++;
			}else{
				result[k]=helper[j];
				j++;
			}
			k++;
		}                                           
		while(i<=mid){
			result[k]=helper[i];
			i++;k++;
		}
	}
	public static void main(String[] args){
		new MergerKSortedArrays().compute();
	}
}
