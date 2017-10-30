package problems.dataStructure.arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HourGlass {

	public static int calculateHourGlassSum(int[][] arr, int row,int col){
		int sum = 0;
		
		for(int i=row; i<row+3;i++){
				for(int j=col; j<col+3;j++){
					if(i == row || i == row+2 || (i == row+1 && j == col+1)){
						try{
							sum = sum +  arr[i][j];
						}
						catch(Exception e){
							e.printStackTrace();	
						}
					}
				}
				
				
			}
		return sum;

	}


	public static void main(String[] args) {
		int n = 6;
		int arr[][]= {
				{1, 1, 1, 0, 0, 0},
				{0, 1, 0 ,0 ,0, 0},
				{1, 1, 1, 0, 0, 0,},
				{0, 9, 2, -4, -4, 0},
				{0, 0, 0 ,-2, 0, 0},
				{0, 0, -1, -2, -4, 0}
		};

		int max=0;
		int sum=0;
		for(int i=0; i<4;i++){
			for(int j=0; j<4;j++){
			sum = calculateHourGlassSum(arr,i,j);
			if(i==0 && j==0){
				max = sum;
			}
			if(sum > max){
				max = sum;
			}
			}
		}
		System.out.println(max);

	}



}
