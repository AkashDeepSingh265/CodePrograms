package CF;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class MashMoksh_reverseoperation_414c {
	
	public int getInversionCount(int[] ary){
		return new MergeSortInversion(ary).getInversionCount();
	}
	public void compute(){
		FastIntArrayStreamReader in = null;
		PrintWriter out = null;
		try{
			in = new FastIntArrayStreamReader(System.in);
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
			int n =  in.readInt();
			int size = 1<<n;
			int[] input = in.readIntarray(size);
			int q = in.readInt();
			for(int i=0;i<q;i++){
				int nextq=in.readInt();
				for(int j=1;j<=1<<n-nextq;j++){
					int prev = (int) ((j-1)*(1<<nextq));
					int end = (int) (prev + (1<<nextq));
					ReverseArray(input,prev,end-1);
				}
				
				out.println(getInversionCount(input.clone()));
			}
		}finally{
			in.close();
			out.flush();
			out.close();
		}
	}
	
	private void ReverseArray(int[] input, int start, int end) {
		int i = 0;
		int mid = (start+end)/2;
		int temp;
		while(start+i<=mid){
			temp=input[start+i];
			input[start+i] = input[end-i];
			input[end-i]=temp;
			i++;
		}
	}
	public static void main(String[] args){
		new MashMoksh_reverseoperation_414c().compute();
	}
}

class MergeSortInversion{
	private int[] ary;
	private int[] helper;
	
	public MergeSortInversion(int[] ary){
		int length = ary.length;
		this.ary = ary;
		this.helper = new int[length];
	}
	
	public int getInversionCount(){
		return mergerSortInvCount(0,ary.length-1);
	}

	private int mergerSortInvCount(int start, int end) {
		if(start<end){
			int mid = (start+end)/2;
			return mergerSortInvCount(start, mid)+ mergerSortInvCount(mid+1, end) + mergeInvCount(start,mid,end);
		}
		return 0;
	}

	private int mergeInvCount(int start, int mid, int end) {
		for(int i = start;i<=end;i++){
			helper[i] = ary[i];
		}
		int i = start;
		int j=mid+1;
		int k = start;
		int count=0;
		while(i<=mid&&j<=end){
			if(helper[i]<=helper[j]){
				ary[k]=helper[i];
				i++;
			}else{
				ary[k]=helper[j];
				j++;
				count = count + mid+1-i;
			}
			k++;
		}
		while(i<=mid){
			ary[k] = helper[i];
			i++;k++;
		}
		return count;
	}
}

//class FastIntArrayStreamReader{
//	private InputStream inStream;
//	private byte[] buf = new byte[1024];
//	private int curpos;
//	private int numChars;
//	public FastIntArrayStreamReader(InputStream stream){
//		this.inStream = stream;
//	}
//	public int[] readIntarray(int size){
//		int[] input = new int[size];
//		for(int i=0;i<size;i++){
//			input[i] = readInt();
//		}
//		return input;
//	}
//	public int readInt() {
//		int c = read();
//		while(isWhiteSpcae(c)){
//			c = read();
//		}
//		int result=0;
//		do{
//			result = result*10;
//			result = result + c - '0';
//			c=read();
//		}while(!isWhiteSpcae(c));
//		return result;
//	}
//	private boolean isWhiteSpcae(int c) {
//		return c == '\n' ||c == ' ' || c == '\r' || c=='\t' || c==-1;
//	}
//	public int read() {
//		if(numChars == -1) throw new InputMismatchException();
//		if(curpos>=numChars){
//			curpos = 0;
//			try {
//				numChars = inStream.read(buf);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(numChars<=0)return -1;
//		}
//		return buf[curpos++];
//		
//	}
//	public void close(){
//		try {
//			inStream.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}