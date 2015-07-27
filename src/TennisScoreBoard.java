
public class TennisScoreBoard {
	
	private static final int MIN_WINNING_SCORE = 4;
	private static final int WINNING_DIFF = 2;
	private static final int ADV_DIFF = 1;
	private static final int DEUCE_CONDITION = 3;
	
	
	private static final String[] scoreStrings = {"0","15","30","40","GAME"};
	
	private int scorePlayerA;
	private int scorePlayerB;
	private boolean gameOver;

	TennisScoreBoard(){
		scorePlayerA = 0;
		scorePlayerB = 0;
		gameOver = false;
	}
	
	
	TennisScoreBoard(String pointSequence){
		scorePlayerA = 0;
		scorePlayerB = 0;
		for(char player: pointSequence.toCharArray()){
			addPoint(player);
		}
		gameOver = false;
	}
	
	public String scoreString() {

		if (scorePlayerA >=  DEUCE_CONDITION  &&  scorePlayerB >= DEUCE_CONDITION ) {
		
			return deuceScoreString();
		
		} else if (scorePlayerA == MIN_WINNING_SCORE){
			
			gameOver = true;
			return "Player 1: Game Player 2: _" ; 
		
		} else if (scorePlayerB == MIN_WINNING_SCORE){
			
			gameOver = true;
			return "Player 1: _ Player 2: Game" ; 
		
		} else {		
		
			return "Player 1: " + scoreStrings[scorePlayerA] + " Player 2: " + scoreStrings[scorePlayerB] ; 
			
		}
	}

	public int getWinner() {
		
		if (scorePlayerA >=  DEUCE_CONDITION  &&  scorePlayerB >= DEUCE_CONDITION ) {
			if(scorePlayerA - scorePlayerB >= WINNING_DIFF) return 1;
			else if(scorePlayerB - scorePlayerA >= WINNING_DIFF) return 2;
			else return 0;
				
		} else if (scorePlayerA == MIN_WINNING_SCORE) {
			return 1;
	    } else if (scorePlayerB == MIN_WINNING_SCORE) {
	    	return 2;
		} else {
			return 0;
		}
		
	}
	
	private String deuceScoreString() {
		
		int currentDiff = Math.abs(scorePlayerA-scorePlayerB);
		
		if (currentDiff == 0) {		
			
			return "Player 1: 40 Player 2: 40" ;
			
		} else if ( currentDiff == ADV_DIFF) {
				
			if(scorePlayerA < scorePlayerB) return "Player 1: 40 Player 2: Adv" ; 
			else return "Player 1: Adv Player 2: 40" ; 
		
		} else {
			
			gameOver = true;
			
			if(scorePlayerA < scorePlayerB) return "Player 1: _ Player 2: Game" ; 
			else return "Player 1: Game Player 2: _" ;
		} 
		
	}
		

	public void addPoint (char player){
		if(Character.toLowerCase(player) == 'a'){
			scorePlayerA +=1;
		}
		else if(Character.toLowerCase(player) == 'b'){
			scorePlayerB +=1;
		}
		else{
			System.out.println("Invalid character");
		}
	}
}
