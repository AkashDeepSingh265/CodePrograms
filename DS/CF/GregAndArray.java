package CF;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class GregAndArray {

	private int[] numArray;
	private Operation[] opArray;
	private BinaryIndexedTree tree;
	private int n;
	private int m;
	public void compute(){
		FastIntArrayStreamReader in = null;
		PrintWriter out = null ;
		try{
			in = new FastIntArrayStreamReader(System.in);
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
			//String firstLine = in.readLine();
			n = in.readInt();
			 m = in.readInt();
			int k = in.readInt();
			numArray = in.readIntarray(n);
			opArray = new Operation[m+1];
     			createBinaryIndexedTree();
			int start,end,val;
			for(int i=0;i<m;i++){
				start = in.readInt();
				end = in.readInt();
				val=in.readInt();
				opArray[i+1] = new Operation(start, end, val);
			}
			for(int i=0;i<k;i++){
				int OpStart = in.readInt();
				int opEnd = in.readInt();
				for(int j= OpStart;j<=opEnd;j++){
					executeOperation(opArray[j]);
				}
			}
			out.print(tree.readIndex(1));
			for(int i=1;i<n;i++){
				out.print(" "+tree.readIndex(i+1));
			}
		}finally{
			in.close();
			out.close();
		}
		
	}
	private void executeOperation(Operation operation) {
		tree.updateIndex(operation.start, operation.incrementalVal);
		if(operation.end<n){
			tree.updateIndex(operation.end+1, -operation.incrementalVal);
		}
	}
	private void createBinaryIndexedTree() {
		tree=new BinaryIndexedTree(n);
		tree.updateIndex(1, numArray[0]);
		for(int i=1;i<n;i++){
			tree.updateIndex(i+1,numArray[i]-numArray[i-1]);
		}
	}
	public static void main(String[] args){
		new GregAndArray().compute();
	}
	
	private class BinaryIndexedTree{
		private long[] tree;
		private int size;
		
		public BinaryIndexedTree(int size){
			tree = new long[size+1];
			this.size = size+1;
		}
		
		public long readIndex(int index){
			long sum =0;
			while(index>0){
				sum = sum + tree[index];
				index = index - (index&-index);
			}
			return sum;
		}
		
		public void updateIndex(int index , int val){
			while(index < size){
				tree[index] = tree[index]+ val;
				index = index + (index&-index);
			}
		}
	}
	
	private class Operation{
		private int start;
		private int end;
		private int incrementalVal;
		
		public Operation(int start,int end,int val){
			this.start = start;
			this.end= end;
			this.incrementalVal = val;
		}
	}
}
 class FastIntArrayStreamReader{
	private InputStream inStream;
	private byte[] buf = new byte[1024];
	private int curpos;
	private int numChars;
	public FastIntArrayStreamReader(InputStream stream){
		this.inStream = stream;
	}
	public int[] readIntarray(int size){
		int[] input = new int[size];
		for(int i=0;i<size;i++){
			input[i] = readInt();
		}
		return input;
	}
	public int readInt() {
		int c = read();
		while(isWhiteSpcae(c)){
			c = read();
		}
		int result=0;
		do{
			result = result*10;
			result = result + c - '0';
			c=read();
		}while(!isWhiteSpcae(c));
		return result;
	}
	private boolean isWhiteSpcae(int c) {
		return c == '\n' ||c == ' ' || c == '\r' || c=='\t' || c==-1;
	}
	public int read() {
		if(numChars == -1) throw new InputMismatchException();
		if(curpos>=numChars){
			curpos = 0;
			try {
				numChars = inStream.read(buf);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(numChars<=0)return -1;
		}
		return buf[curpos++];
	}
	public void close(){
		try {
			inStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}