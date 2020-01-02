package nutanix;

public class Problem2 {

	public static void main(String[] args) {
		
		System.out.println(new Problem2().jumsp(10, new int[] {4,3,2,6,8,3,1,9,6,2}));

	}

	public static int jumsp(int n, int[] array) {
		if(array== null || array.length <=1) return 0;

		int count = 1;
		int a = array[0];
		int b = array[0];

		for(int i=1; i<array.length;i++){
			if(i == array.length-1) return count;
			if(a ==0 && b == 0) return 0;
			a--;
			b--;
			b = Integer.max(b, array[i]);
			if(a==0){
				a = b;
				count++;
			}
		}
		return count;
	}

}
