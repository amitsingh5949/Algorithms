package visa;

public class problem5 {

	public static void main(String[] args) {
		
		//System.out.println(new problem5().variantsCount(3, 2, 3, 3, 2, 15));
		
		//System.out.println(new problem5().variantsCount(3, 1, 1, 1,2,4));
		
		System.out.println(new problem5().variantsCount(409600, 33996, 983759161, 184331615, 2441, 133016888443636305l));
		

	}

	public static long variantsCount(int n, int s0, int k, int b, int m, long a){

		long[] set = new long[n];
		set[0]=s0;

		for(int i=1; i<n;i++) {
			set[i] = ((k*set[i-1]+b)%m)+1+set[i-1];
		}

		long count = 0; 
		
		for(int i=0; i<set.length; i++) {
			
			int j = set.length-1;
			while(j>=i && set[i]*set[j] > a ) {
				j--;
			}
			
			if(j >= i) {
				count += (j-i)*2 +1;
			}
			
		}
		return count;
	}
}
