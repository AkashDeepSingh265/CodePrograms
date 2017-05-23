package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Counting_kngaroos_372A {

	public void compute(){
		BufferedReader in = null ;
		try{
			in =  new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(in.readLine());
			ArrayList<Integer> sizeList = new ArrayList<Integer>(n);
			
			for(int i=0;i<n;i++){
				sizeList.add(Integer.parseInt(in.readLine()));
			}
			Collections.sort(sizeList);
			int count=0;
			for(int i=n-1, j=(n-1)/2
					;i>=(n-1)/2+1&&j>=0;
					){
				if(sizeList.get(i)>=2*sizeList.get(j)){
					count++;
					i--;
					j--;
				}else{
					j--;
				}
			}
			System.out.println(n-count);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args){
		new Counting_kngaroos_372A().compute();
		System.exit(0);
	}
}
