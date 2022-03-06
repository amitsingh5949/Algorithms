package gs.neharika;

public class Solution1 {

	public static void main(String[] args) {

		String S = "a10b";
		String T = "10a1";

		System.out.println(new Solution1().solution(S, T));

	}

	public boolean solution(String S , String T) {

		String sNew = expand(S);
		String tNew = expand(T);

		if(sNew.length() != tNew.length()) return false;


		for(int i=0; i<sNew.length(); i++) {

			char ch1 = sNew.charAt(i);
			char ch2 = tNew.charAt(i);

			if( ch1 != ch2 && ch1 != '?' && ch2 !='?') {
				return false;
			}
		}
		return true;
	}

	public String expand(String s) {
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);

			if(Character.isDigit(ch)) {

				StringBuilder digitStr = new StringBuilder();

				while(i<s.length() && Character.isDigit(s.charAt(i)) ) {
					char chNew = s.charAt(i);
					if(Character.isDigit(chNew)) {
						digitStr.append(chNew);
					}
					i++;
				}
				i--;

				int digit = Integer.parseInt(digitStr.toString());
				for(int k=0; k<digit; k++) {
					sb.append('?');
				}

			}
			else {
				sb.append(ch);
			}

		}
		return sb.toString();
	}

}
