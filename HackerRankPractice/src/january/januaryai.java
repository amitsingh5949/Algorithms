package january;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class januaryai {

	public static void main(String[] args) {
		System.out.println(new januaryai().shortestSubstring("asdfkjeghfalawefhaef"));

	}

	public  int shortestSubstring(String s) {
		
		if(s == null || s.length() == 0) return 0;
		String t = getUniqueChars(s);
		String min = minWindow(s, t);
		return min.length();
	}
	
	public String minWindow(String s, String t) {

		String result = "";
		if(s == null || s.length() == 0 || t== null || t.length() == 0 || t.length() > s.length()) return result;

		Map<Character, Integer> inputStrFreqMap = new HashMap<>();
		for(int i=0; i<t.length(); i++) {
			Character ch = t.charAt(i);
			if(inputStrFreqMap.containsKey(ch)) {
				inputStrFreqMap.put(ch, inputStrFreqMap.get(ch) + 1);
			}
			else {
				inputStrFreqMap.put(ch, 1);
			}
		}
		int required = inputStrFreqMap.size();
		int formed = 0;
		Map<Character, Integer> windowStrFreqMap = new HashMap<>();

		int begin = 0, end = 0;

		int[] resultArr = new int[] {-1,0,0};

		while(end < s.length()) {
			Character ch = s.charAt(end);
			if(windowStrFreqMap.containsKey(ch)) {
				windowStrFreqMap.put(ch, windowStrFreqMap.get(ch) + 1);
			}
			else {
				windowStrFreqMap.put(ch, 1);
			}
			if(inputStrFreqMap.containsKey(ch) && inputStrFreqMap.get(ch).intValue() == windowStrFreqMap.get(ch).intValue()) {
				formed++;
			}
			if(formed == required) {

				while(begin <= end && formed == required) {

					if(resultArr[0] == -1 || (end - begin + 1) < resultArr[0]) {
						resultArr[0] = end - begin + 1;
						resultArr[1] = begin;
						resultArr[2] = end;
					}

					Character removedCharFromBegin = s.charAt(begin);
					if(windowStrFreqMap.containsKey(removedCharFromBegin)) {
						windowStrFreqMap.put(removedCharFromBegin, windowStrFreqMap.get(removedCharFromBegin) - 1);
					}
					if(inputStrFreqMap.containsKey(removedCharFromBegin) &&
							windowStrFreqMap.get(removedCharFromBegin).intValue() < inputStrFreqMap.get(removedCharFromBegin).intValue()) {
						formed--;
					}
					begin++;
				}
			}
			end++;
		}
		if(resultArr[0] != -1) {
			result = s.substring(resultArr[1], (resultArr[2] + 1));
		}
		return result;
	}
	
	public String getUniqueChars(String s) {
		Set<Character> set = new HashSet<>();
		for(char ch : s.toCharArray()) {
			set.add(ch);
		}
		String res = "";
		for(char ch : set) {
			res += ch;
		}
		return res;
	}

}
