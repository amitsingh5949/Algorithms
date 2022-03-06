package competor;

public class Solution1 {

	public static void main(String[] args) {
		
		//int N = 268;
		//int N = 670;
		//int N = 0;
	    //int N = -999;
	    int N = -2999;
		
		System.out.println(new Solution1().solution(N));

	}

	public int solution(int N) {
		
		StringBuilder str = null;
		
		boolean flag = false;

		if(N >= 0) {

			 str = new StringBuilder(Integer.valueOf(N).toString());

			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(ch < '5') {
					str.insert(i, "5");
					flag  = true;
					break;
				}
			}
			
			if(!flag) {
				str.insert(str.length()-1, "5");
			}
		}
		else {
			 str = new StringBuilder(Integer.valueOf(Math.abs(N)).toString());

			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(ch > '5') {
					str.insert(i, "5");
					flag  = true;
					break;
				}
			}
			
			if(!flag) {
				str.insert(str.length()-1, "5");
			}
			str.insert(0, "-");
		}
		
		return Integer.parseInt(str.toString());
	}

}
