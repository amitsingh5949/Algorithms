package com.target.chess.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class BoardTest {

	@Test
	public void testPrintBoardState() {
		String output = "rnbkqbnr|pppppppp|8|8|8|8|PPPPPPPP|RNBKQBNR";
		Board board = new Board();
		String str = board.printBoardState();
		assertNotNull(str);
		assertTrue("Testing print board method : ", (output.equals(str)));
	}
	
	
}
