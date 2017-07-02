package ChessDesign;

public class Board {

	private Slot[][] board;
	
	public Board(){
		this.board = new Slot[8][8];
		initializeBoard();
	}

	public void setPeice(int x ,int y,Piece piece){
		board[x][y].setPiece(piece);
	}
	
	public void removePeice(int x ,int y){
		board[x][y].setPiece(null);
	}
	
	public Slot getSlot(int x, int y){
		return board[x][y];
	}
	
	
	private void initializeBoard() {
		// TODO Auto-generated method stub
		
	}
}
