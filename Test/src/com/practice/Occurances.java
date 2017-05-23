package com.practice;

import java.util.ArrayList;

public class Occurances {
	private char matrix[][];
	private String expression ;
	private Integer noOfOccurances=0;
	
	private ArrayList<Integer> getValidCoordinates(String move){
		ArrayList<Integer> validMoves= new ArrayList<Integer>();
		validMoves.add(1);
		validMoves.add(2);
		validMoves.add(3);
		validMoves.add(4);
		switch(move){
			case "UP" :
				validMoves.remove(1);
				break;
			case "DOWN" :
				validMoves.remove(0);
				break;
			case "LEFT" :
				validMoves.remove(3);
				break;
			case "RIGHT":	
				validMoves.remove(2);
				break;
		}
		return validMoves;
	}
	private void noOfOccurances(int x , int y , int index , String move){
		ArrayList<Integer> validCoordinates = getValidCoordinates(move);
		
		for(int i=0;i< validCoordinates.size();i++){
			findnoOfOccurances(validCoordinates.get(i),x,y,index);
		}
	}
	private void findnoOfOccurances(Integer integer, int x, int y, int index) {
		switch (integer) {
		case 1:
			if(x-1>=0 &&matrix[x-1][y] == expression.charAt(index)){
				if(index == (expression.length()-1)){
					noOfOccurances++;
					return;
				}
				noOfOccurances(x-1, y, index+1,"UP");
			}
			break;
		case 2:
			if(x+1 < 4 && matrix[x+1][y] == expression.charAt(index)){
				if(index == (expression.length()-1)){
					noOfOccurances++;
					return;
				}
				noOfOccurances(x+1, y, index+1,"DOWN");
			}
			break;
		case 3:
			if(y-1>=0&&matrix[x][y-1] == expression.charAt(index)){
				if(index == (expression.length()-1)){
					noOfOccurances++;
					return;
				}
				noOfOccurances(x, y-1, index+1,"LEFT");
			}
			break;
		case 4:
			if(y+1< 5 && matrix[x][y+1] == expression.charAt(index)){
				if(index == (expression.length()-1)){
					noOfOccurances++;
					return;
				}
				noOfOccurances(x, y+1, index+1,"RIGHT");
			}
			break;	
		}
		
	}
	public Occurances(char mat[][] , String exp) {
		
		this.matrix = mat;
		this.expression = exp;
		for(int row =0;row < 4;row++){
			for(int col = 0 ; col < 5; col++){
				if(matrix[row][col] == expression.charAt(0)){
					noOfOccurances(row,col, 1,"none");
				}
			}
		}
	}
	
	public static void main(String args[]){
		char abc[][]= { 
				{'A','B' ,'C','D','A'},
				{'B', 'C' ,'D', 'A', 'A'},
				{'C', 'D' ,'A' ,'A' ,'B'},
				{'D' ,'A' ,'A' ,'B', 'C'} 
		};
		String toSearch = "ABCDA";
		Occurances oc = new Occurances(abc, toSearch);
		System.out.println(oc.noOfOccurances);
	}
}
