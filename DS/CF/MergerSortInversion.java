package CF;

public class MergerSortInversion {

	private int[] array;
	private int[] helper;
	private int mergeSort(int start , int end){
		if(start < end){
			int mid = (start+end)/2;
			return mergeSort(start, mid) +
			mergeSort(mid+1, end)+
			merge(start,mid,end);
		}
		return 0;
	}
	
	private int merge(int start, int mid, int end) {
		for(int i=start;i<=end;i++){
			helper[i] = array[i];
		}
		int i = start;
		int j = mid+1;
		int k=start;
		int invCount=0;
		while(i<=mid&&j<=end){
			if(helper[i]<=helper[j]){
				array[k]=helper[i];
				i++;
			}else{
				array[k]=helper[j];
				j++;
				invCount =invCount+ mid+1-i;
			}
			k++;
		}
		while(i<=mid){
			array[k]=helper[i];
			i++;k++;
		}
		return invCount;
	}

	public void sort(int[] ary ){
		int length = ary.length;
		this.array = ary;
		this.helper = new int[length];
		System.out.println(mergeSort(0,length-1));
	}
	public static void main(String[] args){
		int[] input = {4,3,2,1};
		new MergerSortInversion().sort(input);
	}
}
