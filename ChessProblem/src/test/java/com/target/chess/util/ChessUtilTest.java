package com.target.chess.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessUtilTest {

	@Test
	public void testGetRowIndex() {
		assertTrue("Testing print board method : ", (0 == ChessUtil.getRowIndex('a')));
	}

}
