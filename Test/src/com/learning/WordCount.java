package com.learning;

import java.io.FileReader;
import java.io.IOException;

public class WordCount {

	public void count(){
		FileReader in = null;
		try{
			in = new FileReader("C:\\Users\\Aakash\\Desktop\\test.txt");
			int cur = in.read();
			while(iswhiteSpcaeChar(cur)&&cur!=-1){
				cur = in.read();
			}
			if(cur==-1){
				System.out.println(0);
				return;
			}
			int count = 0;
			while(cur!=-1){
				count++;
				while(!iswhiteSpcaeChar(cur)){
					cur = in.read();
				}
				if(cur==-1){
					System.out.println(count);
					return;
				}
				while(iswhiteSpcaeChar(cur)&&cur!=-1){
					cur = in.read();
				}
			}
			System.out.println(count);
		}catch(IOException e){
			
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
			}
		}
	}
	private boolean iswhiteSpcaeChar(int cur) {
		return cur == '\n'|| cur == ' '|| cur == -1||cur=='\r';
	}
	public static void main(String[] args) {
		new WordCount().count();
		System.exit(0);
	}

}
