package ICPC;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Main {
	
	public static void main(String[] args){
		 new Main().readInput();
		 System.exit(0);
	}

	private void   readInput() {
		Scanner in = null;
		PrintWriter out = null;
		try{
			in = new Scanner(System.in);
			out = new PrintWriter(System.out,true);
			String line1,line2;
			int M,N,count,index,inputIndex = 0;
			
			while(in.hasNext()){
				count=0;
				line1=in.nextLine();
				List<Integer> st=new ArrayList<>();
				if(line1.equals("0 0")){
					return;
				}
				inputIndex++;
				line2 = in.nextLine();
				String[] inputary = line1.split(" ");
				M = Integer.parseInt(inputary[0]);
				N=Integer.parseInt(inputary[1]);
				String[] inputcards = line2.split(" ");
				List<Integer> lst = new ArrayList<>();
				for(int i=0;i<inputcards.length;i++){
					lst.add(Integer.parseInt(inputcards[i]));
				}
				Collections.sort(lst);
				//index = getIndex(lst,M,N);
				initizlizeSet(st,lst.get(0),M*N);
				st.removeAll(lst);
				out.write("case "+ inputIndex +": "+numberOfwins(lst,st,M,N)+"\n");
				in.nextLine();
				
			}	
		}finally{
			in.close();
			out.close();
		}
	}

	private int numberOfwins(List<Integer> lst, List<Integer> st,
			int m, int n) {
		int wins=0;
		for(int i = lst.size()-1;i>=0;i--){
			if(!checkforsmallestGreatestNumber(lst.get(i),st)){
				wins++;
			}
			
			
		}
		return wins;
	}

	private boolean checkforsmallestGreatestNumber(Integer integer, List<Integer> st) {
		for(Integer val : st ){
			if(val > integer){
				st.remove(val);
				return true;
				
			}
		}
		return false;
		
	}

	private void initizlizeSet(List<Integer> st, int m, int n) {
		for(int val = m; val <= n;val++){
			st.add(val);
		}
	}

	private int getIndex(List<Integer> lst, int m, int n) {
		for(int val = (m-1)*n +1; val <= m*n;val++){
			if(lst.contains(val)){
				return lst.indexOf(val);
			}
		}
		return 0;
	}
}
