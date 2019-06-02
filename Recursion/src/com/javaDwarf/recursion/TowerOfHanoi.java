package com.javaDwarf.recursion;

public class TowerOfHanoi {

	public long moves;

	public static void main(String[] args) {
		new TowerOfHanoi().toh(2, 1, 3,2,0 );
	}


	public void toh(int n, int fromTower, int toTower, int auxTower, long moves) {
		toh1(n, fromTower, toTower, auxTower, moves);
		System.out.println(this.moves);
	}

	public void toh1(int n, int fromTower, int toTower, int auxTower, long moves) {
		if (n <= 0) return;
		toh1(n-1, fromTower, auxTower, toTower , moves);
		System.out.println("move disk "+ n +" from rod " + fromTower + " to rod " + toTower);
		toh1(n-1, auxTower, toTower, fromTower , moves);
		this.moves++;
	}
}
