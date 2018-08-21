package com.javadwarf.dynamicprogramming.twoString;

public class CoinChnage {

	public static void main(String[] args) {

		/*Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int coin[] = new int[size];
			for(int j=0; j<size; j++){
				coin[j] =  in.nextInt();
			}
			int W = in.nextInt();
			System.out.println(coinChange(W, coin));
		}
		in.close();*/
		System.out.println(coinChange1(34, new int[]{3,6,22,28}));
	}

	public static int coinChange(int W, int[] coin){
		int max = 0 ;
		int[][] matrix = new int[coin.length+1][W+1]; 

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(i== 0 || j==0){
					matrix[i][j] = 0;
				}
				else {
					if(coin[i-1]>j){
						matrix[i][j] = matrix[i-1][j];
					}
					else{
						int temp = 0;
						if(j%coin[i-1] == 0) temp++;
						for(int k=j ; k>=0; k=(k-coin[i-1])){
							temp += matrix[i-1][k];
						}
						matrix[i][j] = temp;
						if(j==W && matrix[i][j] > max)
							max = matrix[i][j];
					}
				}
			}
		}
		return max;
	}
	
	public static int coinChange1(int W, int[] coin){
		int max = 0 ;
		int[][] matrix = new int[coin.length+1][W+1]; 

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(i== 0 || j==0){
					matrix[i][j] = 0;
				}
				else {
					if(coin[i-1]>j){
						matrix[i][j] = matrix[i-1][j];
					}
					else if(coin[i-1] == j){
						matrix[i][j] = matrix[i-1][j]+1;
					}
					else{
						matrix[i][j] = matrix[i-1][j]+matrix[i][j-coin[i-1]];
					}
					if(j==W && matrix[i][j] > max)
						max = matrix[i][j];
				}
			}
		}
		return max;
	}

}
