package wayfair;

public class Problem1 {

	public static void main(String[] args) {
		
		System.out.println(new Problem1().solution("eedaaad"));
		System.out.println(new Problem1().solution("xxxtxxx"));
		System.out.println(new Problem1().solution("uuuuxaaaaxuuu"));

	}
	
	
	public String solution(String S) {
		
		if(S == null || S.length() < 3) return S;
		
		String res = S.charAt(0)+"";
		
		int count = 1;
		char current = S.charAt(0);
		
		for(int i= 1; i<S.length(); i++) {
			
			char temp = S.charAt(i);
			
			if(temp == current) {
				
				if(count < 2) {
					res += temp;
					count++;
				}
				else {
					continue;
				}
			}
			else {
				res += temp;
				current = temp;
				count = 1;
			}
		}
		
		return res;
		
		
		
	}

}
