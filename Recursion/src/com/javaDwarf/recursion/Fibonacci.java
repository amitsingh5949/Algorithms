package com.javaDwarf.recursion;

public class Fibonacci {
	static int  initialCount = 0;
	public static void main(String[] args) {
		fibonacci(9);
		fibonacciRecursion(9);
	}

	private static void fibonacci(int count) {
		int a = 0;
		int b = 1;
		int temp= 0;
		int sum = 0;
		for(int i=1; i<=count;i++){
			System.out.print(a+" ");
			sum += a;
			temp = b;
			b = b+a;
			a = temp;
		}
		System.out.println("\nSum : "+ sum);		
	}


	private static void fibonacciRecursion(int count) {
		fibRec(0,1,count,0);
		System.out.println("\nLast number is : "+ fibRecSmart(count));
	}

	private static void fibRec(int i, int j, int count, int sum) {
		if(initialCount == count){
			System.out.println("\nSum : "+ sum);
			return;
		}
		System.out.print(i +" ");
		sum+= i;
		initialCount++;
		fibRec(j, i+j, count, sum);

	}

	private static int fibRecSmart(int i) {
		
		/* if you want sequence with initial number 1,1 like 1 1 2 3 5 8 13 21 ....
		 if( i<=2 ){ 
			return 1;
		}
		 */
		// if you want sequence with initial number 0,1 like 0,1 1 2 3 5 8 13 21 ....
		if( i<=3 ){
			return 1;
		}
		int num = fibRecSmart(i-1) +fibRecSmart(i-2);
		//System.out.print(num +" ");
		return num;
	}
}
