package original;

public class PuzzleWord {
	private int xCoordinate;
	private int yCoordinate;
	private int direction;
	private String word;
	
	
	
	public PuzzleWord(int xCoordinate, int yCoordinate, int direction, String word) {
		setxCoordinate(xCoordinate);
		setyCoordinate(yCoordinate);
		setDirection(direction);
		setWord(word);
	}
	
	public int getxCoordinate() {
		return xCoordinate;
	}
	private void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	private void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public int getDirection() {
		return direction;
	}
	private void setDirection(int direction) {
		this.direction = direction;
	}
	public String getWord() {
		return word;
	}
	private void setWord(String word) {
		this.word = word;
	}
	
	public int getWordLength() {
		return word.length();
	}
}
