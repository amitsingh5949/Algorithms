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
					if(dungeon[i][j] >= 0) {
						e.initialPower = Integer.MAX_VALUE;
						e.powerup = dungeon[i][j];
					}
					else {
						e.initialPower = Integer.MAX_VALUE - dungeon[i][j];
					}
					matrix[i][j] = e;
				}
				else if(i==0 && j!=0) {
					Element left = matrix[i][j-1];
					Element e = new Element();
					if(dungeon[i][j] >= 0) {
						e.initialPower = left.initialPower;
						e.powerup = matrix[i][j-1].powerup + dungeon[i][j];
					}
					else {
						if(left.powerup - dungeon[i][j] >= 0) {
							e.initialPower = left.initialPower;
							e.powerup = left.powerup -  dungeon[i][j];
						}
						else {
							e.powerup = 0;
							e.initialPower = left.initialPower - (Math.abs(left.powerup -  dungeon[i][j]));
						}
					}
					matrix[i][j] = e;
				}
				else if(i!=0 && j==0) {
					Element top = matrix[i-1][j];
					Element e = new Element();
					if(dungeon[i][j] >= 0) {
						e.initialPower = top.initialPower;
						e.powerup = top.powerup + dungeon[i][j];
					}
					else {
						if(top.powerup - dungeon[i][j] >= 0) {
							e.initialPower = top.initialPower;
							e.powerup = top.powerup -  dungeon[i][j];
						}
						else {
							e.powerup = 0;
							e.initialPower = top.initialPower - (Math.abs(top.powerup -  dungeon[i][j]));
						}
					}
					matrix[i][j] = e;
				}
				else {
					Element left = matrix[i][j-1];
					Element top = matrix[i-1][j];
					Element e = new Element();
					if(dungeon[i][j] >= 0) {
						e.initialPower = (left.initialPower > top.initialPower) ? left.initialPower : top.initialPower;
						e.powerup =  (left.initialPower > top.initialPower) ? left.powerup + dungeon[i][j] : top.powerup + dungeon[i][j];
					}
					else {
						if(top.powerup - dungeon[i][j] >= 0 && left.powerup - dungeon[i][j] >= 0) {
							e.initialPower = (left.initialPower > top.initialPower) ? left.initialPower : top.initialPower;
							e.powerup =  (left.initialPower > top.initialPower) ?  left.powerup -  dungeon[i][j] :  top.powerup -  dungeon[i][j];;
						}
						else {
							int leftRemain = left.initialPower  - (Math.abs(left.powerup -  dungeon[i][j]));
							int topRemain = top.initialPower  - (Math.abs(top.powerup -  dungeon[i][j]));
							e.powerup = 0;
							e.initialPower = leftRemain > topRemain ? leftRemain : topRemain;
						}
					}
					matrix[i][j] = e;
				}
			}
		}
		return Integer.MAX_VALUE - matrix[dungeon.length-1][dungeon[0].length-1].initialPower + 1 ;
	}

	class Element{

		int initialPower;
		int powerup;

		public Element() {}

		public Element(int initialPower, int powerup) {
			super();
			this.initialPower = initialPower;
			this.powerup = powerup;
		}

		
	}
}
