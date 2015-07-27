import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 
 */

/**
 * @author test
 *
 */
public class TestMain {


	@Test
	public void emptyTennisScoreBoard() {
		TennisScoreBoard wimbledonScores = new TennisScoreBoard();
		assertEquals( "Player 1: 0 Player 2: 0",wimbledonScores.scoreString());
	}

	@Test
	public void testGetWinner() {
		TennisScoreBoard wimbledonScores;
		
	}
	
	
	void testWinner(String pointSequence, int winner) {
		TennisScoreBoard wimbledonScores = new TennisScoreBoard();
		for(char player: pointSequence.toCharArray()){
			wimbledonScores.addPoint(player);
		}
		assertEquals(2, wimbledonScores.getWinner());
	}

}
