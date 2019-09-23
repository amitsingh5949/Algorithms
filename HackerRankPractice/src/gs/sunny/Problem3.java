package gs.sunny;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

	public static void main(String[] args) {

		System.out.println(analyzeInvestments("ABBCZBAC"));
	}

	public static long analyzeInvestments(String s) {

		long result = 0l;

		Map<Character, Integer> map = new HashMap<>();

		int formed  = 0;
		int required = 3;

		int start = 0;
		

		for(int j=0; j<s.length(); j++) {

			Character ch = s.charAt(j);
			int count = map.getOrDefault(ch, 0);
			map.put(ch, count+1);
			
			if((ch == 'A' || ch == 'B' || ch=='C') && (count == 0)) {
				formed++;
			}
			
			if(formed == required) {
				
				result += s.length() - j;
				
				while(formed == required) {
					Character ch1 = s.charAt(start++);
					int count1 = map.getOrDefault(ch1, 0);
					map.put(ch1, count1-1);
					if((ch1 == 'A' || ch1 == 'B' || ch1=='C') && (count1 == 1)) {
						formed--;
					}
					else {
						result += s.length() - j;
					}
				}
				
			}
		}

		return result;

	}




}
