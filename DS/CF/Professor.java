package CF;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Professor {

	public void compute(){
		Scanner in = null;
		PrintWriter out = null;
		try{
			in = new Scanner(new BufferedInputStream(System.in));
			out = new PrintWriter(System.out);
			int numOfLectureWords = in.nextInt();
			int numOfWords = in.nextInt();
			HashMap<String,String> wordMap = new HashMap<>();
			String CurLine,first,second;
			in.nextLine();
			while(numOfWords>0){
				CurLine = in.nextLine();
				first = CurLine.split(" ")[0];
				second = CurLine.split(" ")[1];
				if(second.length()<first.length()){
					wordMap.put(first,second);
				}else{
					wordMap.put(first,first);
				}
				numOfWords--;
			}
			String[] lecture = in.nextLine().split(" ");
			for(String s : lecture){
				out.print(wordMap.get(s)+ " ");
			}
		}finally{
			in.close();
			out.close();
		}
	}
	public static void main(String[] args) {
		new Professor().compute();
	}

}

