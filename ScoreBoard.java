import java.util.*;

class ScoreBoard{
	
	private static final int WINNING_DIFF = 2;
	private static final int ADV_DIFF = 1;
	
	private static final String[] scoreStrings = {"0","15","30","40","GAME"};
	private static int scoreFirstPlayer = 0;
	private static int scoreSecondPlayer = 0;
	
	public static void main (String[] args) throws java.lang.Exception {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the point sequence of game (e.g. aabb , ababa):");
		String pointSequence = reader.nextLine();
		showScore(pointSequence);
		reader.close();
	}

	public static void showScore(String pointSequence ) {
		for ( char playerId : pointSequence.toCharArray()){
			if (isValidSequence(playerId)) {
				setScore(playerId);
			} else {
				System.out.println("Invalid Player Id encounterd!");
				break;
			}
			
			if(scoreFirstPlayer <= 3 && scoreSecondPlayer <= 3 ) {
				printScores();
			} else if (firstplayerwins()) {
				System.out.println("Player 1: Game  Player 2: _");
				break;
			} else if (secondplayerwins()) {
				System.out.println("Player 1: _  Player 2: Game");
				break;
			} else {
				String currentScore = deuceSituation();
				System.out.println(currentScore);
				if (currentScore.contains("over")) {
					break;
				}
			}
		}
	}

	public static boolean isValidSequence(char playerId) {
		return playerId == 'a' || playerId == 'b' ;
	}

	public static void setScore(char playerId){
		if (playerId == 'a') {
			scoreFirstPlayer++;
		} else {
			scoreSecondPlayer++;
		}
	}

	public static void printScores(){
		String firstPlayerPoints = scoreStrings[scoreFirstPlayer];
		String secondPlayerPoints = scoreStrings[scoreSecondPlayer];
		System.out.println("Player 1: " + firstPlayerPoints + " Player 2: " + secondPlayerPoints) ;
	}
	
	public static boolean firstplayerwins() {
		return scoreFirstPlayer == 4 && (scoreFirstPlayer - scoreSecondPlayer > 1) ;
	}
	
	public static boolean secondplayerwins() {
		return scoreSecondPlayer == 4 && (scoreSecondPlayer - scoreFirstPlayer > 1) ;
	}
		
	public static String deuceSituation() {
		int scoreDifference = scoreFirstPlayer - scoreSecondPlayer;
		if (scoreDifference == 0) {
			return "Player 1: 40  Player 2: 40";
		} else if (Math.abs(scoreDifference) == ADV_DIFF) {
			if (scoreDifference > 0) {
				return "Player 1: Advantage  Player 2: 40";
			} else {
				return "Player 1: 40  Player 2: Advantage";
			}
		} else if (Math.abs(scoreDifference) == WINNING_DIFF) {
			if (scoreDifference > 0) {
				return "Player 1: Game  Player 2: _";
			} else {
				return "Player 1: _  Player 2: Game";
			}
		} else {
			return "Game already over!";
		}
	}
}