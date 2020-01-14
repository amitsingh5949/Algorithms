package leetcodecontest.jan4;

public class Problem1 {

	public static void main(String[] args) {
		
		char ch = (char) (97+'2');
		System.out.println(ch);

	}

	public String freqAlphabets(String s) {

		String res = "";

		if(s == null || s.length() ==0 ) {
			return res;
		}

		else if(s.length() == 1) {
			char ch = (char) (97 + Integer.parseInt(s.charAt(0)+""));
			return res+ch;
		}
		
		else if(s.length() == 2) {
			char ch1 = (char) (97 + Integer.parseInt(s.charAt(0)+""));
			char ch2 = (char) (97 + Integer.parseInt(s.charAt(0)+""));
			return res+ch1+ch2;
		}
		
		for(int i=2; i<s.length(); i++) {
			
			if(s.charAt(i) == '#') {
				String temp = s.substring(i,i+2);
				char ch = (char) (97 + Integer.parseInt(temp));
				res += ch;
				i = i+2;
				
			}
			else {
				char ch = (char) (97 + Integer.parseInt(s.charAt(i)+""));
				res += ch;
			}
		}
		
		
		return res;
	}
}
