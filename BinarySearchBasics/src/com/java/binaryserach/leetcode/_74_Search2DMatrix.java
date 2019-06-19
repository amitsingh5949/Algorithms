package com.java.binaryserach.leetcode;

public class _74_Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{},
				{23, 30, 34, 50}
		};
		System.out.println(new _74_Search2DMatrix().searchMatrix1(new int[][]{{},{3}}, 3));
		
		System.out.println(new _74_Search2DMatrix().searchMatrix1(new int[][]{{1},{},{3}}, 3));
		
		System.out.println(new _74_Search2DMatrix().searchMatrix(matrix, 3));
		System.out.println(new _74_Search2DMatrix().searchMatrix(matrix, 11));
		System.out.println(new _74_Search2DMatrix().searchMatrix(matrix, 50));
		System.out.println(new _74_Search2DMatrix().searchMatrix(matrix, 26));
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

	// leetcode solution
	public boolean searchMatrix1(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0) return false;
		int n = matrix[0].length;

		// binary search
		int left = 0, right = m * n - 1;
		int pivotIdx, pivotElement;
		while (left <= right) {
			pivotIdx = (left + right) / 2;
			pivotElement = matrix[pivotIdx / n][pivotIdx % n];
			if (target == pivotElement) return true;
			else {
				if (target < pivotElement) right = pivotIdx - 1;
				else left = pivotIdx + 1;
			}
		}
		return false;

	}

}
