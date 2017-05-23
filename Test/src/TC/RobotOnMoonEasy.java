package TC;

public class RobotOnMoonEasy {

	public String isSafeCommand(String[] board , String s ){
	
		int[] CurPos = new int[2];
		findstart(board,CurPos);
		int curX=CurPos[0];
		int curY = CurPos[1];
		for(int i = 0 ; i < s.length();i++){
			
			switch (s.charAt(i)) {
			case 'L':
				curY--;
				if(!validatePos(curX,curY,board)) return "Dead";
				if(board[curX].charAt(curY)=='#'){
					curY++;
				}	
				break;
			case 'R':
				curY++;
				if(!validatePos(curX,curY,board)) return "Dead";
				if(board[curX].charAt(curY)=='#'){
					curY--;
				}	
				break;
			case 'U': 
				curX--;
				if(!validatePos(curX,curY,board)) return "Dead";
				if(board[curX].charAt(curY)=='#'){
					curX++;
				}	
				break;
			case 'D' : 
				curX++;
				if(!validatePos(curX,curY,board)) return "Dead";
				if(board[curX].charAt(curY)=='#'){
					curX--;
				}
				break;
			}
		}
		return "Alive";
	}

	private boolean validatePos(int curX, int curY, String[] board) {
		return (curX >=0 && curX <board.length && curY >=0 && curY < board[0].length()) ;
	}




	private void findstart(String[] board, int[] coordinateS) {
		for(int i = 0 ; i < board.length;i++){
			if(board[i].indexOf('S')>=0){
				coordinateS[0]=i;
				coordinateS[1]=board[i].indexOf('S');
				return;
			}
		}
	}

}