package com.javaDwarf.recursion;

import java.util.Scanner;

/*
 * We would like to calculate the value of nth term in series 1,1,2,6,24,120,720,...
 */
public class FactorialProblem {

	public static void main(String[] args) {
		System.out.println("Please enter a number");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		if(n>0){
			System.out.println("Nth term in Factoril is : " + calculateFactorail(n));
		}
		else{
			System.out.println("Please enter a valid number greater than zero");

		}
	}

	public static int 	calculateFactorail(int n){
		if(n>0){
			return n * calculateFactorail(n-1);
		}
		else{
			return 1;
		}
	}

}
