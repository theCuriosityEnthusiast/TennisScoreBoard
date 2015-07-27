
public class TennisScoreBoard {
	
	private static final int WINNING_DIFF = 2;
	private static final int ADV_DIFF = 1;
	private static final int DEUCE_POINT = 4;
	
	private static final String[] scoreStrings = {"0","15","30","40"};
	
	private int scorePlayerA;
	private int scorePlayerB;

	
	TennisScoreBoard(){
		scorePlayerA = 0;
		scorePlayerB = 0;
	}
		
	public String showScore() {

		if(scorePlayerA >= DEUCE_POINT || scorePlayerA >= DEUCE_POINT ) {
			 return dueHandler();
		} else {
			String scoreStringB = scoreStrings[scorePlayerB];
			String scoreStringA = scoreStrings[scorePlayerA];
			return "Player 1: " + scoreStringA + " Player 2: " + scoreStringB ; 
		}
	}


	private String dueHandler() {
		
		int currentDiff = Math.abs(scorePlayerA-scorePlayerB);
		
		if (currentDiff == 0) {		
			
			return "Player 1: 40 Player 2: 40" ;
			
		} else if ( currentDiff == ADV_DIFF) {
				
			if(scorePlayerA < scorePlayerB) return "Player 1: 40 Player 2: Adv" ; 
			else return "Player 1: Adv Player 2: 40" ; 
		
		} else if ( currentDiff == WINNING_DIFF) { 
			
			if(scorePlayerA < scorePlayerB) return "Player 1: _ Player 2: Game" ; 
			else return "Player 1: Game Player 2: _" ;
			
		} else {	
			return "INVALID POINT SEQUENCE";
		}
		
	}
	

	public void setScore(String pointSequence){
		for(char ch: pointSequence.toCharArray()){
			if(Character.toLowerCase(ch) == 'a'){
				scorePlayerA +=1;
			}
			else if(Character.toLowerCase(ch) == 'b'){
				scorePlayerB +=1;
			}
			else{
				System.out.println("Invalid character");
				break;
			}
			System.out.println(showScore());
		}
	}

	
}
