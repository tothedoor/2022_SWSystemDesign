package before;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreReportMain {
	private static Scanner scanner = new Scanner(System.in) ;
	private List<Student> students = new ArrayList<Student>();
	private enum Command {
		INIT,
		QUIT, 
		ADD_STUDENT,
		ADD_SCORES,	
		SHOW, 
		CLEAR;
	}
	
	public static void main(String[] args) {
		ScoreReportMain ui = new ScoreReportMain() ;

		boolean isQuitInput = false ;
		while ( !isQuitInput ) {
			ui.showCommands() ;
			Command command = getCommand();
			
			switch ( command ) {
			case QUIT: isQuitInput = true ; break ;
			case ADD_STUDENT: ui.addStudent() ; break ;
			case ADD_SCORES: ui.addScores() ; break ;
			case SHOW: ui.showStudentReport() ; break ;
			case CLEAR: ui.clearStudentScores() ; break ;
			case INIT: ui.init() ; break ;
			default: break ;
			}
		}
		System.out.println("Bye");
	}

	private static Command getCommand() {
		int inputValue = scanner.nextInt();
		Command command = Command.values()[inputValue + 1];
		return command;
	}

	private void showCommands() {
		System.out.println("\nSelect a command !");
		System.out.println("\t -1. Init");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. Add student");
		System.out.println("\t 2. Add scores");
		System.out.println("\t 3. Show student report");
		System.out.println("\t 4. Clear student scores");
	}
	
	private void init() {
		Student james = new Student("James") ;
		james.addScore(20) ;
		james.addScore(10) ;

		Student brown = new Student("Brown") ;
		brown.addScore(30) ;
		brown.addScore(10) ;
		brown.addScore(20) ;
		brown.addScore(60) ;
		brown.addScore(50) ;

		students.add(james) ;
		students.add(brown) ;
	}
	
	private void clearStudentScores() {
		System.out.println("Enter student name: ");
		String name = scanner.next() ;
		Student st = getStudentByName(name);
		boolean isFind = st != null;
		
		if (isFind) {
			st.clearScores();
		} else {
			System.out.println(name + " does not exist!");
		}
	}
	
	private void showStudentReport() {
		System.out.println("Enter student name: ");
		String name = scanner.next() ;
		Student st = getStudentByName(name);
		boolean isFind = st != null;
		
		if (isFind) {
			st.showScores();
		} else {
			System.out.println(name + " does not exist!");
		}
	}
	
	private void addScores() {
		System.out.println("Enter student name: ");
		String name = scanner.next() ;
		Student st = getStudentByName(name);
		boolean isFind = st != null;
		
		if (isFind) {
			System.out.println("Enter scores( -1 for quit): ") ;
			while ( true ) {
				int inputValue = scanner.nextInt() ;
				if ( inputValue == -1 ) break ;
				st.addScore(inputValue) ;
			}
		} else {
			System.out.println(name + " does not exist!");
		}
	}

	private void addStudent() {
		System.out.println("Enter student name: ");
		String name = scanner.next() ;
		Student newStudent = new Student(name) ;
		boolean isExistStudent = getStudentByName(name) != null;
		
		if (isExistStudent) {
			System.out.println(name + " already exist!");
		} else {
			students.add(newStudent) ;
		}
		
	}
	
	private Student getStudentByName(String name) {
		boolean isFind;
		
		for ( Student st : students ) {
			isFind = st.getName().equals(name);
			if (isFind) {
				return st;
			}
		}
		
		return null;
	}
}