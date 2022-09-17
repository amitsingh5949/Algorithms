package com.java.binaryserach.leetcode;

public class _74_Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{},
				{23, 30, 34, 50}
		};
		System.out.println(new _74_Search2DMatrix().searchMatrixOptimal(new int[][]{{},{3}}, 3));

		System.out.println(new _74_Search2DMatrix().searchMatrixOptimal(new int[][]{{1},{},{3}}, 3));

		System.out.println(new _74_Search2DMatrix().searchMatrix(matrix, 3));
		System.out.println(new _74_Search2DMatrix().searchMatrix(matrix, 11));
		System.out.println(new _74_Search2DMatrix().searchMatrix(matrix, 50));
		System.out.println(new _74_Search2DMatrix().searchMatrix(matrix, 26));
	}

	// Brute force would be to check all elements o(n*m)
	// IN optimized Brute Force, we move along the diagonal (we start from left bottom or right top coordinate)
	// we cannot start from a point where both row and column decrease or increase i.e (0,0) or (end, end) coordinate will not work
	// Time : o(n+m)

	public boolean searchMatrixOptimisedBruteForce(int[][] matrix, int target) {

		if(matrix == null || matrix.length ==0 ) return false;

		int i = matrix.length-1;
		int j  = 0;

		while(i>=0 && j < matrix[i].length ){

			if(matrix[i][j] == target) return true;
			else if(matrix[i][j] < target){
				j++;
			}
			else{
				i--;
			}
		}
		return false;
	}

	
	// space complexity - o(n*m)
	//time - o(log(n*m))
  //Ran on leetcode successfully : Yes
  // Problem faced  : No
	//Approach : since it is sorted in spiral way, we can think of this 2 array as 1D array (row place one after the other)
    // once we find the mid we need to get to the cell by using (int x = mid/m int y = mid%m; ).
	public boolean searchMatrixOptimal(int[][] matrix, int target) {

		if(matrix == null || matrix.length ==0 ) return false;

		int n = matrix.length;
		int m = matrix[0].length;

		int start = 0;
		int end = n*m-1;
		int mid = start + (end - start)/2;

		while(start <= end){

			mid = start + (end - start)/2;

			int x = mid/m;
			int y = mid%m;

			if(matrix[x][y] == target){
				return true;
			}
			else if(matrix[x][y] < target){
				start = mid+1;
			}
			else{
				end = mid-1;
			}           
		}
		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {

		if(matrix == null || matrix.length == 0) return false;

		boolean result = false;

		int start = 0;
		int end = matrix.length-1;
		int mid = start + (end-start)/2;

		while(start <= end) {

			mid = start + (end-start)/2;

			if(matrix[mid].length == 0) {
				start = mid+1;
				continue;
			}

			if(matrix[mid][0] == target) {
				return true;
			}
			else if(matrix[mid][0] > target) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}

		int row = start;
		if(row != 0) {
			row = matrix[start-1].length == 0? start-2:start-1;
		}
		start = 0;
		end = matrix[0].length-1;
		mid = start + (end-start)/2;

		while(start <= end) {
			mid = start + (end-start)/2;
			if(matrix[row][mid] == target) {
				return true;
			}
			else if(matrix[row][mid] > target) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}

		}

		return result;
	}



}
