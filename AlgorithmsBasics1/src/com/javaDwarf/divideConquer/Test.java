package com.javaDwarf.divideConquer;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int N= Integer.parseInt(s.nextLine());
		String str = s.nextLine();
		s.close();
		String[] strArr = str.split(" ");
		for(int i = 0; i<strArr.length;i++){
			int num = Integer.parseInt(strArr[i]);
			for(int j = 1; j<=num;j++){
				if(j%3!=0 && j%5!=0){
					System.out.println(j);
				}
				else if(j%3==0 && j%5!=0){
					System.out.println("Fizz");
				}
				if(j%3!=0 && j%5==0){
					System.out.println("Buzz");
				}
				else if(j%3==0 && j%5==0){
					System.out.println("FizzBuzz");
				}
				
			}
		}
		
	}

}
