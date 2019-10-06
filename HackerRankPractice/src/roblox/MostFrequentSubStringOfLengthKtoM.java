package roblox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class  MostFrequentSubStringOfLengthKtoM {



	public static void main(String[] args) {
		//System.out.println(getMaxOccurrences("abcde",2, 4, 26));
		System.out.println(getMaxOccurrences("ababab",2,3,4));
		//		/ System.out.println(x);

	}

	static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
		char[] nums = s.toCharArray();
		int max = 0;
		String maxStr = "";

		Map<String,Integer>  map = new HashMap<>();

		if(nums == null || nums.length == 0) return 0;

		int count = (int)Math.pow(2.0, nums.length*1.0) -1;

		for(int i=0; i<=count; i++) {

			String res = "";
			HashSet<Character> uniquecharset= new HashSet();
			for(int j=0; j<nums.length; j++) {

				if((i & (1 << j)) !=0) {
					res += nums[j]; 
					uniquecharset.add(nums[j]);
				}
			}

			int countAdd = map.getOrDefault(res, 0);
			map.put(res,countAdd+1);

			if(countAdd+1> max && res.length() >=minLength && res.length()<=maxLength && uniquecharset.size()<=maxUnique) {
				max = countAdd+1;
				maxStr = res;
			}
		}
		return getCount(s, maxStr);
	}
	
	public static int getCount(String str, String findStr ) {
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1){

			lastIndex = str.indexOf(findStr,lastIndex);

			if(lastIndex != -1){
				count ++;
				lastIndex += findStr.length();
			}
		}
		return count;
	}


}
