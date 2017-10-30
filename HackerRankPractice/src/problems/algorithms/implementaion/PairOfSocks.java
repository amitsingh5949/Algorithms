package problems.algorithms.implementaion;

import java.util.Arrays;
import java.util.Scanner;

public class PairOfSocks {
	static int sockMerchant(int n, int[] ar) {
        int numPair  = 0 ;
        Arrays.sort(ar);
        for(int i=0; i<ar.length-1;i++){
        	if(ar[i]==ar[i+1]){
        		numPair++;
        		i++;
        	}
        }
        return numPair;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }*/
        int n =9 ;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10 ,20};
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
