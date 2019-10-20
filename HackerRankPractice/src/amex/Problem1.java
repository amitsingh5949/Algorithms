package amex;

public class Problem1 {

	public static void main(String[] args) {
		System.out.println(solution(268));
		System.out.println(solution(670));
		System.out.println(solution(0));
		System.out.println(solution(-999));

	}
	
	public static  int solution(int N) {
		StringBuffer x = new StringBuffer(Integer.valueOf(N).toString());
		int max = Integer.MIN_VALUE;
		for(int i= 0; i<x.length(); i++) {
			if(x.charAt(i) == '-') continue;
			StringBuffer str = new StringBuffer(Integer.valueOf(N).toString());
			String temp  = str.insert(i, "5").toString();
			max = Math.max(max, Integer.parseInt(temp));
		}
		return max;
    }

}
