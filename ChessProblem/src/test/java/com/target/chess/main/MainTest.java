package com.target.chess.main;

import static org.junit.Assert.*;

import org.junit.Test;


public class MainTest {

	@Test
	public void testMove() {
		String input = "p7b6b";
		String output = "rnbkqbnr|pppppppp|8|8|8|1P6|P1PPPPPP|RNBKQBNR";
		Board board = new Board();
		try {
			board.move(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String str = board.printBoardState();
		assertNotNull(str);
		assertTrue("Testing print board method : ", (output.equals(str)));
	}
	
	
}
