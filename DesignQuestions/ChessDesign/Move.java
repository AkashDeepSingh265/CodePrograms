package ChessDesign;

public class Move {
	private int currentX;
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
	public int getToBeX() {
		return toBeX;
	}
	public void setToBeX(int toBeX) {
		this.toBeX = toBeX;
	}
	public int getToBeY() {
		return toBeY;
	}
	public void setToBeY(int toBeY) {
		this.toBeY = toBeY;
	}
	private int currentY;
	private int toBeX;
	private int toBeY;
	
}
