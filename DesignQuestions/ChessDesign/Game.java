package ChessDesign;

public class Game {
	private Player p1,p2;
	private Board board;
	
	public Game(){
		this.board = new Board();
	}
	
	public void setPlayer1(Player player){
		this.p1= player;
	}
	
	public void setPlayer2(Player player){
		this.p2= player;
	}
	
	public Player getPlayer1(){
		return p1;
	}
	
	public Player getPlayer2(){
		return p2;
	}
	
	public void executePlayerTurn(Player player){
		Move move = player.getNextMove();
		Piece piece= board.getSlot(move.getCurrentX(), move.getCurrentY()).getPiece();
		if(piece.isValidMove(move)){
			//check conditions here .
			//if opponent piece then removePiece
			//if opponent piece is king then set board status as gameOver
			
		}else{
			System.out.println("Not a valid move . Select again");
			executePlayerTurn(player);
		}
	}
	
	public void startGame(){
		setPlayer1(new HumanPlayer("player1"));
		setPlayer1(new HumanPlayer("player2"));
		while(true){
			
			
		}
	}
}
