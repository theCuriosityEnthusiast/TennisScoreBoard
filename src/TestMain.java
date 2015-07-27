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
		wimbledonScores = new TennisScoreBoard("");
		assertEquals( "Player 1: 0 Player 2: 0",wimbledonScores.scoreString());
	}

	@Test
	public void testGetWinner() {
		TennisScoreBoard wimbledonScores;
		
		wimbledonScores = new TennisScoreBoard("aaaa");
		assertEquals(1, wimbledonScores.getWinner());
		
		wimbledonScores = new TennisScoreBoard("bbbb");
		assertEquals(2, wimbledonScores.getWinner());
		
		wimbledonScores = new TennisScoreBoard("aababa");
		assertEquals(1, wimbledonScores.getWinner());
		
		wimbledonScores = new TennisScoreBoard("abbbab");
		assertEquals(2, wimbledonScores.getWinner());
		
	}

}
