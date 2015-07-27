import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String pointsSequence = input.nextLine();
		
		TennisScoreBoard wimbledonScores = new TennisScoreBoard();
		wimbledonScores.setScore(pointsSequence);
		wimbledonScores.showScore();
	}

}
