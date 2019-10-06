package wealthfront;


public class Problem1 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,0};
		System.out.println(solution(arr));

	}




	public static int solution(int[] A) {

		int min = Integer.MAX_VALUE;

		for (int i=0; i<6; i++) {
			
			int currCount = 0;
			
			for(int j=0; j<A.length; j++) {
				
				int currElement = A[j];
				
				if (currElement != i){
					if((currElement + i) == 7){
						currCount = currCount + 2;
					}
					else{
						currCount = currCount + 1;
					}
				}
			}
			if(currCount < min) {
				min = currCount;
			}
		}
		return min;
	}


}
