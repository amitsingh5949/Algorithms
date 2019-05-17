package com.javadwarf.bitmanipulation.gfg;

public class Findfirstsetbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getFirstSetBitPos(int n){

		int index  = -1;

		for(int i=0; i<32; i++) {
			if((n & (1 << i)) != 0) {
				index = i;
			}
		}

		return index;	        
	}

}
