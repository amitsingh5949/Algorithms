package gs.sunny;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {

	public static void main(String[] args) {

		System.out.println(analyzeInvestments("ABBCZBAC"));
	}

	public static long analyzeInvestments(String s) {

		long result = 0l;

		Set<Character> set = new HashSet<>();

		int end = -1;

		for(int i=0; i<s.length(); i++) {
			end = -1;
			set.clear();
			for(int j=i; j<s.length(); j++) {
				char ch = s.charAt(j);
				if(ch == 'A' || ch == 'B' || ch=='C') {
					set.add(Character.valueOf(ch));
				}
				if(set.size()==3) {
					end = j;
					break;
				}
			}
			
			if(end != -1) {
				result += s.length()-end;
			}

		}

		return result;

	}




}
