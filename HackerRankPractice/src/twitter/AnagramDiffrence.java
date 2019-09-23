package twitter;

import java.util.ArrayList;
import java.util.List;

public class AnagramDiffrence {

	public static void main(String[] args) {
		System.out.println(getMinimumDifference("kj", "jk"));
		System.out.println(getMinimumDifference("kj", "kk"));
		System.out.println(getMinimumDifference("kj", "ii"));
	}

	public static List<Integer> getMinimumDifference(List<String> a, List<String> b){

		List<Integer> result = new ArrayList<>();

		for(int i=0; i<a.size(); i++) {
			result.add(getMinimumDifference(a.get(i), b.get(i)));
		}

		return result;

	}


	public static Integer getMinimumDifference(String a, String b){

		if(a.length() != b.length()) return -1; 

		int count =0;

		int[] arr = new int[26];
		for(char ch : a.toCharArray()) {
			arr[ch - 'a'] += 1;
		}
		for(char ch : b.toCharArray()) {

			if( arr[ch - 'a'] != 0) {
				arr[ch - 'a'] -= 1;
			}
			else {
				count++;
			}
		}

		return count;

	}
}
