package ChessDesign;

public class HumanPlayer implements Player {

	private String playerName;
	
	public HumanPlayer(String name){
		this.playerName=name;
	}
	@Override
	public Move getNextMove() {
		// TODO GetInput From terminal and send next move
		return null;
	}

}
