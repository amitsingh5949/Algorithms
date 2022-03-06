package gs.neharika;

public class Solution2 {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,1,6};
		int[] arr3 = {1,6,2,3};
		System.out.println(new Solution2().solution(arr1));
		System.out.println(new Solution2().solution(arr2));
		System.out.println(new Solution2().solution(arr3));

	}

	public int solution(int[] A) {

		int min = Integer.MAX_VALUE;

		for(int i=1; i<=6; i++) {

			int temp  = 0;

			for(int j=0; j<A.length; j++) {

				if(i==j) {
					continue;
				}
				else if((A[j] == 1 && i == 6) ||
						(A[j] == 2 && i == 5) ||
						(A[j] == 3 && i == 4) ||
						(A[j] == 4 && i == 3) ||
						(A[j] == 5 && i == 2) ||
						(A[j] == 6 && i == 1) ) {
					temp +=2;
				}
				else {
					temp++;
				}

			}
			min = Math.min(min, temp);
		}
		return min;
	}

}
