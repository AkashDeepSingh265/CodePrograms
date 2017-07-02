package ChessDesign;

public class Pawn extends Piece {

	public Pawn(PieceColor color) {
		super(color);
	}

	@Override
	public boolean isValidMove(Move move) {
		//check move here
		return false;
	}

}
