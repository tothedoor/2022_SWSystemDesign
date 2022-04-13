import java.util.ArrayList;
import java.util.List;

public class ScoreRecord extends ScoreRecordSubject {
	private List<Integer> scores = new ArrayList<Integer>();

	public void addScore(int score) {
		scores.add(score);
		notifyViews();
	}

	public List<Integer> getScoreRecord() {
		return scores;
	}
}
