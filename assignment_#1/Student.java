package before;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<Integer> scores = new ArrayList<>() ;
	private int sum;
	
	public Student(String name) {
		super();
		this.name = name;
		sum = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getScores() {
		return scores;
	}
	
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	
	public void clearScores() {
		scores.clear();
		sum = 0;
	}
	public void addScore(int newScore) {
		scores.add(newScore);
		sum += newScore;
	}
	
	public void showScores() {
		for (int score : scores) {
			System.out.print(score + " ");
		}
		System.out.println("Sum: " + sum);
	}
}
