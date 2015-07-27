
public class TennisScoreBoard {
	
	private int scoreA;
	private int scoreB;
	
	TennisScoreBoard(){
		scoreA = 0;
		scoreB = 0;
	}
		
	public String showScore() {
		String[] scores = {"love","15","30","40"};
		
		if(scoreA >= 4 || scoreA >= 4) {
			 return dueHandler();
		} else {
			String scoreStringB = scores[scoreB];
			String  scoreStringA = scores[scoreA];
			return "Player 1: " + scoreStringA + " Player 2: " + scoreStringB ; 
		}
	}


	private String dueHandler() {
		if (scoreA == scoreB) {
			return "DEUCE" ; 
		} else if ( Math.abs(scoreA-scoreB)>=2 ) {
			
			if(scoreA < scoreB) return "Player 1: _ Player 2: Game" ; 
			else return "Player 1: Game Player 2: _" ; 
			
		} else {
			return null;
		} 
	}
	

	public void setScore(String pointSequence){
		for(char ch: pointSequence.toCharArray()){
			if(Character.toLowerCase(ch) == 'a'){
				scoreA +=1;
			}
			else if(Character.toLowerCase(ch) == 'b'){
				scoreB +=1;
			}
			else{
				System.out.println("Invalid character");
				break;
			}
			System.out.println(showScore());
		}
	}

	
}
