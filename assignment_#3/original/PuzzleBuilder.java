package original;

public class PuzzleBuilder {
	private static final int HORIZONTAL = 0;
	private PuzzleWord[] words;
	private int index;

	private String name;

	public PuzzleBuilder(String name, int size) {
		this.name = name;
		words = new PuzzleWord[size];
		index = 0;
	}

	public int getSize() {
		return index;
	}
	
	public void setSize(int value) {
		this.index = value;
	}
	public int addWord(String word, int x, int y, int direction) throws Exception {
		if (isExistWord(word, direction) == true)
			throw new Exception("[" + word + "] is already exist!");			
		if (isOverlap(word, x, y, direction) == true)
			throw new Exception("The location you want to use is already in use.");
		
		words[index] = new PuzzleWord(x, y, direction, word);

		setSize(index+1);
		
		return 0;
	}

	private boolean isOverlap(String word, int x, int y, int direction) {
		boolean result = false;
		for (int i = 0; i < index; i++) {
			if (words[i].getDirection() == HORIZONTAL) { // 가로
				if (direction == HORIZONTAL) { // 가로
					boolean isOverlap = words[i].getyCoordinate() == y && ((x >= words[i].getxCoordinate() && x <= words[i].getxCoordinate() + words[i].getWordLength())
							|| (x + word.length() >= words[i].getxCoordinate() && x + word.length() <= words[i].getxCoordinate() + words[i].getWordLength()));
					if (isOverlap == true) {
						result = true;
						break;
					}
				} else { // 세로
					boolean isOverlap = x >= words[i].getxCoordinate() && x <= words[i].getxCoordinate() + words[i].getWordLength() && words[i].getyCoordinate() >= y && words[i].getyCoordinate() <= y + word.length();
					if (isOverlap == true) {
						result = true;
						break;
					}
				}
			} else { // 세로
				if (direction == HORIZONTAL) { // 가로
					boolean isOverlap = words[i].getxCoordinate() >= x && words[i].getxCoordinate() <= x + word.length() && y >= words[i].getyCoordinate() && y <= words[i].getyCoordinate() + words[i].getWordLength();
					if (isOverlap == true) {
						result = true;
						break;
					}
				} else { // 세로
					boolean isOverlap = words[i].getxCoordinate() == x && ((y >= words[i].getyCoordinate() && y <= words[i].getyCoordinate() + words[i].getWordLength())
							|| (y + word.length() >= words[i].getyCoordinate() && y + word.length() <= words[i].getyCoordinate() + words[i].getWordLength()));
					if (isOverlap == true) {
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}
	
	private boolean isExistWord(String word, int direction) {
		boolean result = false;
		for (int i = 0; i < index; i++) { // 같은 방향의 똑같은 단어가 있는 경우
			boolean isSameWord = words[i].getWord().compareTo(word) == 0;
			boolean isSameDirection = words[i].getDirection() == direction;
			if (isSameWord == true && isSameDirection == true) {
				result = true;
				break;
			}	
		}
		return result;
	}

	public int getWordPosition(int coord, String word, int dir) {
		for (int i = 0; i < index; i++) {
			boolean isSameWord = words[i].getWord().compareTo(word) == 0;
			boolean isSameDirection = words[i].getDirection() == dir;
			if (isSameWord == true && isSameDirection == true) {
				if (coord == 0)
					return words[i].getxCoordinate();
				else
					return words[i].getyCoordinate();
			}
		}

		return -1;
	}

	public int getPoint() {
		int totalPoint = 0;
		for (int i = 0; i < index; i++) {
			int point;
			if (words[i].getDirection() == 0)
				point = words[i].getWordLength();
			else
				point = words[i].getWordLength() * 2;

			totalPoint += point;
		}
		return totalPoint;
	}

	public String getShortReport(boolean isHTML) {
		String value;
		if (isHTML) {
			value = "<H1> Report on Puzzle <EM> " + name + "</EM></H1>\n";
		} else {
			value = "Report on Puzzle " + name + "\n";
		}
		int point = 0;
		for (int i = 0; i < index; i++) {
			int result;
			if (words[i].getDirection() == 0)
				result = words[i].getWordLength();
			else
				result = words[i].getWordLength() * 2;

			if (isHTML)
				value += "\tWord: <B>" + words[i] + "</B>\tPoint: <B> " + result + "</B>\n";
			else
				value += "\tWord: " + words[i] + "\tPoint: " + result + "\n";

			point += result;
		}
		if (isHTML) {
			value += "<HR> Total Point: <B>" + point + "</B><P>\n";
		} else {
			value += "Total Point: " + point + "\n";
		}
		return value;
	}

	public String getFullReport(boolean isHTML) {
		String value;
		if (isHTML) {
			value = "<H1> Report on Puzzle <EM> " + name + "</EM></H1>\n";
		} else {
			value = "Report on Puzzle " + name + "\n";
		}
		int point = 0;
		for (int i = 0; i < index; i++) {
			int result;
			if (words[i].getDirection() == 0)
				result = words[i].getWordLength();
			else
				result = words[i].getWordLength() * 2;

			if (isHTML)
				value += "\tWord: <B>" + words[i] + "\tPosition: [" + words[i].getxCoordinate() + ", " + words[i].getyCoordinate() + "]" + "\tDir: " + words[i].getDirection()
						+ " </B> Point: <B> " + result + "</B>\n";
			else
				value += "\tWord: " + words[i] + "\tPosition: [" + words[i].getxCoordinate() + ", " + words[i].getyCoordinate() + "]" + "\tDir: " + words[i].getDirection()
						+ " Point: " + result + "\n";

			point += result;
		}
		if (isHTML) {
			value += "<HR> Total Point: <B>" + point + "</B><P>\n";
		} else {
			value += "Total Point: " + point + "\n";
		}
		return value;
	}
}
