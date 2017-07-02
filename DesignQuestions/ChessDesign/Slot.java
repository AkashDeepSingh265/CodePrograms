package ChessDesign;

public class Slot {

	private int currentX;
	private int currentY;
	private Piece piece;
	
	public Slot(Piece piece,int x,int y){
		this.currentX=x;
		this.currentY=y;
		this.piece=piece;
	}
	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	
}
