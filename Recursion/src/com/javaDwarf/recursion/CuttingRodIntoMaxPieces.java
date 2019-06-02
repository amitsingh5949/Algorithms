package com.javaDwarf.recursion;

public class CuttingRodIntoMaxPieces {
	
	public static int res = 0;

	public static void main(String[] args) {
		
		//res  = 0; 
		//System.out.println(maxPieces(5, new int[] {1,2,3})?res:-1);
		
		res  = 0; 
		System.out.println(maxPieces(23, new int[] {9,11,12})?res:-1);
		
		//res  = 0; 
		//System.out.println(maxPieces(5, new int[] {2,4,6})?res:-1);

	}
	
	public static boolean maxPieces(int l, int[] dim) {
		
		if(l == 0 ) return true;
		
		boolean canBeBroken = false;
		
		for(int i=0; i< dim.length; i++) {
			if(dim[i] <= l) {
				canBeBroken = true;
				res = res  + 1;
				canBeBroken = maxPieces(l-dim[i], dim);
				if(!canBeBroken) {
					res = res - 1 ;
				}
			}
		}
		return canBeBroken;
	}

}
