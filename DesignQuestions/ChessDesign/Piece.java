package ChessDesign;

public abstract class Piece {

	private PieceColor color;
	
	public Piece(PieceColor color){
		this.color=color;
	}
	
	public abstract boolean isValidMove(Move move);
		
	
}
