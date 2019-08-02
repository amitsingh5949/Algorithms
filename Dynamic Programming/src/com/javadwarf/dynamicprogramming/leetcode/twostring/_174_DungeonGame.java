package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _174_DungeonGame {

	public static void main(String[] args) {

	}

	public int calculateMinimumHP(int[][] dungeon) {

		Element[][] matrix = new Element[dungeon.length][dungeon[0].length];

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				if(i==0 && j==0) {
					Element e = new Element();
					matrix[i][j] = e;
				}
				else if(i==0 && j!=0) {
				}
				else if(i!=0 && j==0) {
				}
				else {
				}

			}
		}

		return matrix[dungeon.length-1][dungeon[0].length-1].valNeeded ;
	}

	class Element{

		int valNeeded;
		int finalValOfCell;

		public Element() {}

		public Element(int valNeeded, int finalValOfCell) {
			this.valNeeded = valNeeded;
			this.finalValOfCell = finalValOfCell;
		}
	}
}
