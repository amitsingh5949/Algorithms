package competor;

public class Solution {

	public static void main(String[] args) {
		//String S = "azABaabza";
		//String S = "TacoCat";
		String S = "AcZCbaBz";
		//String S = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(new Solution().solution(S));
	}
	

	public int solution(String S) {
		int max = -1;
		for(int i=0; i<S.length(); i++) {
			for(int j=i+1; j<=S.length(); j++) {
				String str = S.substring(i,j);
				if(isBalanced(str)) {
					max = Math.max(max, str.length());
				}
			}
			
		}
		return max;
	}
	
	public boolean isBalanced(String S) {
		int[] smallCaseCount = new int[26];
		int[] capitalCaseCount = new int[26];

		for(int i = 0; i<S.length(); i++) {

			char ch = S.charAt(i);
			if (Character.getType(ch) == Character.UPPERCASE_LETTER) {
				capitalCaseCount[ch - 'A'] += 1;
			}
			else {
				smallCaseCount[ch -'a'] += 1;
			}
		}

		for(int i=0;i<26; i++) {
			if( (smallCaseCount[i] == 0 && capitalCaseCount[i] != 0) ||
					(smallCaseCount[i] != 0 && capitalCaseCount[i] == 0)){
				return false;
			}
		}
		return true;
	}

}
