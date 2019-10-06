package wealthfront;

import demo.Solution;

public class Problem2 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,0};
		System.out.println(solution(arr));

	}


	public static int solution(int[] A) {
		
		if(A==null || A.length==0) return 0;
		
		if( A.length==1) return 1;
		

		boolean[] visited = new boolean[A.length];
		int max = 0;

		for(int i=0; i<A.length; i++) {

			if(!visited[i] ) {
				int count = 0;
				int start = A[i];
				count++;
				visited[start] = true;

				int next = A[start];
				while(start != next) {
					count++;
					visited[next] = true;
					next = A[next];
				}

				if(count > max) {
					max = count;
				}
			}
		}

		return max;


	}
	/*
	public int solution(int[] A) {

		int[] arr = new int[6];
		int res = 2 * A.length ;

		int i = 0;
		while(i<A.length) {
			arr[A[i]- 1] += 1;
			i++;
		}

		for(i = 0; i < 6; i++) {
			int x = A.length - arr[i] + arr[5 - i] ;
			if(x < res) {
				res = x;
			}
		}
		return res;
	}
	 */

}
