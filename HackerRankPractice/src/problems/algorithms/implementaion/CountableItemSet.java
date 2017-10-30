package problems.algorithms.implementaion;

import java.util.Scanner;

public class CountableItemSet {
	
	static int getTotalX(int[] a, int[] b) {
		int count = 0;
		if(a.length>0 && b.length > 0){
			int start = (a[0]<b[0])?a[0]:b[0];
			int end = (a[a.length-1]>b[b.length-1])?a[a.length-1]:b[b.length-1];

			for(int i=start; i<=end;i++){
				if(isCountable(i,a,b))
					count++;
			}
		}
		return count;
	}

	static boolean isCountable(int num,int[] a, int[] b ){
		boolean isCountable = true;

		for(int i=0; i<a.length;i++){
			if(num % a[i] !=0){
				isCountable = false;
				break;
			}
			else{
				for(int j=0; j<b.length;j++){
					if(b[j] % num !=0){
						isCountable = false;
						break;
					}
				}
			}
		}
		return isCountable;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];

		for(int a_i = 0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for(int b_i = 0; b_i < m; b_i++){
			b[b_i] = in.nextInt();
		}
		int total = getTotalX(a, b);
		System.out.println(total);
		in.close();
	}
}
