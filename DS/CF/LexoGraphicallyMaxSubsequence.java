package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LexoGraphicallyMaxSubsequence {

	public void compute(){
		BufferedReader in = null;
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			StringBuilder  output = new StringBuilder("") ;//Strings are immutable that is they cannot be chnaged 
			// so whenever we use + a new String Object is created and old value is copied and value to be appended is
			// appended to it . 
			char max = 0;
			char cur = 0;
			for(int i=input.length()-1;i>=0;i--){
				cur = input.charAt(i);
				if(cur - max >= 0){
					max = cur;
					output = output.append(cur);
				} 
			}
			System.out.println(output.reverse());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		new LexoGraphicallyMaxSubsequence().compute();
	}
}
