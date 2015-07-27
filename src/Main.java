import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String pointSequence = input.nextLine();
		
		TennisScoreBoard wimbledonScores = new TennisScoreBoard();
	
		for(char player: pointSequence.toCharArray()){
			wimbledonScores.addPoint(player);
			System.out.println(wimbledonScores.scoreString()); 
		}
	}

}
