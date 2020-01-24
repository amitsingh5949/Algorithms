package nutanix;

public class Problem3 {

	public static void main(String[] args) {

		System.out.println(new Problem3().solve(1, 2));
		System.out.println(new Problem3().solve(3, 5));

	}

	/*public static int solve1(int n, int m) {

		int big = 0;
		int small = 0;

		if(n > m) {
			big = n;
			small = m;
		}
		else {
			big = m;
			small = n;
		}

		int k = 0;
		while(small < big) {
			small = small * 2;
			k++;
		}
		return k + small - big;
	}*/

	public static int solve(int n, int m) {

		int k = 0;
		while (m > n) {
			k++;
			if (m % 2 == 1)
				m++;
			else
				m /= 2;
		}
		return k + n - m;
	}

}
