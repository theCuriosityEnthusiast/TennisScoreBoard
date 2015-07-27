import java.util.*;

class ScoreBoard{
	
	private static final int ADVANTAGE_DIFF = 1;
	
	private static final String[] scoreValues = {"0","15","30","40","GAME"};
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
			
			if (firstplayerwins()) {
				System.out.println("Player 1: Game  Player 2: _");
				break;
			} else if (secondplayerwins()) {
				System.out.println("Player 1: _  Player 2: Game");
				break;
			} else {
				String currentScore = printScores();
				System.out.println(currentScore);
				if (isGameOver(currentScore)) {
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

	public static boolean firstplayerwins() {
		return scoreFirstPlayer == 4 && (scoreFirstPlayer - scoreSecondPlayer > 1) ;
	}
	
	public static boolean secondplayerwins() {
		return scoreSecondPlayer == 4 && (scoreSecondPlayer - scoreFirstPlayer > 1) ;
	}
	
	public static String printScores(){
		if(scoreFirstPlayer <= 3 && scoreSecondPlayer <= 3 ) {
			String firstPlayerPoints = scoreValues[scoreFirstPlayer];
			String secondPlayerPoints = scoreValues[scoreSecondPlayer];
			return "Player 1: " + firstPlayerPoints + " Player 2: " + secondPlayerPoints ;
		} else {
			int scoreDifference = scoreFirstPlayer - scoreSecondPlayer;
			if (scoreDifference == 0) {
				return "Player 1: 40  Player 2: 40";
			} else if (Math.abs(scoreDifference) == ADVANTAGE_DIFF) {
				if (scoreDifference > 0) {
					return "Player 1: Advantage  Player 2: 40";
				} else {
					return "Player 1: 40  Player 2: Advantage";
				}
			} else {
				if (scoreDifference > 0) {
					return "Player 1: Game  Player 2: _";
				} else {
					return "Player 1: _  Player 2: Game";
				}
			}
		}
	}
	
	public static boolean isGameOver(String currentScore) {
		return currentScore.contains("Game");
	}
}
