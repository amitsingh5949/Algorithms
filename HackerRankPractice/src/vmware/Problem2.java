package vmware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2 {

	public static void main(String[] args) {
		
		List<String > s = new ArrayList<String>();
		s.add("poke");
		s.add("pkoe");
		s.add("okpe");
		s.add("ekop");
		s.add("pokes");
		s.add("frame");
		s.add("rafem");
		s.add("framer");
		System.out.println(xyz(s));
		

	}
	
	public static List<String> xyz(List<String> s){
		
		for(int i=0; i<s.size()-1;i++) {
			
			String s1 = s.get(i);
			//for(int j=i+1; j<s.size(); j++) {
			int j = i+1;
			while(j<s.size()) {
				//j = i+1;
				String s2 = s.get(j);
				if(isAnagram(s1, s2)) {
					s.remove(s2);	
					j=i+1;
				}
				else
					j++;
			}
			
		}
		Collections.sort(s);
		return s;
	}

	public static boolean isAnagram(String s1, String s2) {

		if(s1.length() != s2.length()) {
			return false;
		}
		else {
			int[] arr = new int[26];

			for(int i=0; i<s1.length(); i++) {
				arr[s1.charAt(i)-'a'] += 1;
			}
			for(int i=0; i<s2.length(); i++) {
				arr[s2.charAt(i)-'a'] -= 1;
			}
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != 0) return false;
			}

		}
		return true;

	}

}
