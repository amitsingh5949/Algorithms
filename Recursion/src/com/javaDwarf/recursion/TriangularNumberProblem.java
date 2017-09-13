package com.javaDwarf.recursion;

import java.util.Scanner;

/*
 * We would like to calculate the value of nth term in series 1,3,6,10,15,21,28,...
 * logic Value of (nterm) = Value of (n-1)th term + n
 * nth term = (square(n)+n)/2
 */
public class TriangularNumberProblem {

	public static void main(String[] args) {
		System.out.println("Please enter a number");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		if(n>0){
			System.out.println("Nth term is : " + calculateValue(n));
		}
		else{
			System.out.println("Please enter a valid number greater than zero");

		}
	}

	public static int 	calculateValue(int n){
		if(n>0){
			return n + calculateValue(n-1);
		}
		else{
			return 0;
		}
	}

}
