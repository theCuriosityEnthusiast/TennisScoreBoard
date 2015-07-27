
public class TennisScoreBoard {
	
	private int scoreA;
	private int scoreB;
	
	TennisScoreBoard(){
		scoreA = 0;
		scoreB = 0;
	}
	
	public void setScore(String pointSequence){
		for(char ch: pointSequence){
			if(ch.toLowerCase().equals('a')){
				scoreA +=1;
			}
			else if(ch.toLowerCase().equals('b')){
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
