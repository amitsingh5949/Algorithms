package com.javadwarf.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinomialCofficientDP {
	static int  initialCount = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int numOfTestCases = in.nextInt();
        
        for(int i=0; i<numOfTestCases; i++){
        	binomialCoff(in.nextInt(), in.nextInt()); 	 
        }
        in.close();
	}

	private static void binomialCoff(int n, int k) {
		System.out.println(binomialCoffRec(n,k));
		//System.out.println(binomialCoffRecMem(n,k, new HashMap<>()));
		System.out.println(binomialCoffRectab(n,k));
	}
	

	private static long binomialCoffRec(int n, int k) {
		if( n==k || k==0 ) return 1L;
		return  binomialCoffRec(n-1,k-1) + binomialCoffRec(n-1,k) ;
	}

	
	private static long binomialCoffRecMem(int n, int k, Map<Long, Long> memory) {
		if( n==k || k==0 ){
			memory.put(Long.valueOf(n-k), 1L);
			return 1L;
		}
		Long num = 0L;
		if(memory.containsKey(Long.valueOf(n-k))){
			num = memory.get(Long.valueOf(n-k));
		}
		else{
			num = binomialCoffRecMem(n-1,k-1,memory) + binomialCoffRecMem(n-2,k,memory) ;
			memory.put(Long.valueOf(n-k), Long.valueOf(num));
		}
		return num; 
	}
	
	private static long binomialCoffRectab(int n, int k) {
		
		if( n==k || k==0 ){
			return 1L;
		}
		
		Long valN = 1L;
		Long valK = 1L;
		Long valN_K = 1L;
			
		for(int i = 1; i<=n; i++){
			
			if(i==k){
				valK = valN*i;	
			}
			if(i==(n-k)){
				valN_K = valN*i;
			}
			valN = valN * i;
		}
		return valN/(valK*valN_K); 
	}
}
