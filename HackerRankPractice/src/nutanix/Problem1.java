package nutanix;

public class Problem1 {

	public static void main(String[] args) {
		new Problem1().solve(4, new int[] {1,2,1,2});
		
		new Problem1().solve(3, new int[] {1,0,1});
		
		new Problem1().solve(3, new int[] {1,2,1});
	}

	public static boolean res = true;

	public static void  solve (int len, int day[]) {
		if(day== null || day.length ==0 ) System.out.println("NO");

		res = true;

		rec(len, day, 0, 0);

		if(res) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}

	}

	public static void rec(int len, int day[], int pos, int remaining){

		int visitor = day[pos];
		visitor -= remaining;

		if(visitor < 0 || (pos == day.length-1 && visitor%2 != 0)) {
			res = false;
			return ;
		}
		
		if((pos == day.length-1 && visitor%2 == 0)) {
			return;
		}

		if(visitor%2 == 0) {
			rec(len, day, pos+1, 0);
		}
		else {
			rec(len, day, pos+1, 1);
		}
	}
}
