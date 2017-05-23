package CF;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;


public class CF_276C_LittleGirlMaxSum {
	private BinaryIndexedTree tree ;
	
	class BinaryIndexedTree{
		private int size;
		private int tree[];
		
		public BinaryIndexedTree(int size){
			this.tree = new int[size+1];
			this.size=size+1;
		}
		
		public int  readIndex(int index){
			int sum = 0 ;
			while(index>0){
				sum = sum+tree[index];
				index = index - (index&-index);
			}
			return sum;
		}
		
		public void  updateIndex(int index,int value){
			while(index < size){
				tree[index] = tree[index] + value;
				index = index + (index&-index);
			}
		}
	}
	
	public void initializeBinaryIndexedTree(int size){
		this.tree = new BinaryIndexedTree(size);
	}
	
	public void compute(){
		Scanner in = null ;
		try{
			in = new Scanner(new BufferedInputStream(System.in));
			//String input = in.nextLine();
			int n = in.nextInt();
			int q = in.nextInt();
			int[] numbers = new int[n];
			int [] frequency = new int [n];
			for(int i = 0 ; i< n ;i++){
				numbers[i] = in.nextInt();
			}
			Arrays.sort(numbers);
			initializeBinaryIndexedTree(n);
			for(int i=0;i<q;i++){
				tree.updateIndex(in.nextInt(),1);
				tree.updateIndex(in.nextInt()+1,-1);
			}
			long sum =0;
			
			for(int i=0;i<n;i++){
				 frequency[i] = tree.readIndex(i+1);
			}
			Arrays.sort(frequency);
			for(int i=0;i<n;i++){
				sum = sum + (long)frequency[i]*numbers[i];
			}
			System.out.println(sum);
			
		}catch(Exception e){
		
		}finally{
			in.close();
		}
	}
	public static void main(String[] args){
		new CF_276C_LittleGirlMaxSum().compute();
		System.exit(0);
	}
}
