package enfusion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem2 {

	public static void main(String[] args) {
		
		System.out.println(new Problem2().substringCalculator("abcde"));

	}
	
	public static long substringCalculator1(String s) {
		Map<String, Integer> substrings = new HashMap<>();
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			String sub = s.substring(i);
			for(int j = 0; j < sub.length(); j++){
				String subDistinct = sub.substring(0, sub.length() - j);
				if(!substrings.containsKey(subDistinct)){
					substrings.put(subDistinct, 1);
					count += 1;
				}
			}
		}
		return count;
	}
	
	public static int substringCalculator(String s) {
        if (s.isEmpty())
            return 0;

        Set<String> set = new HashSet<>();
        int count = 0;
        int p = 0;

        for (int l = s.length(); l >= 1; l--) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l;
                String sub = s.substring(i, j);
                if (!set.contains(sub)) {
                    count++;
                    set.add(sub);
                } else {
                    p++;
                }
            }
        }
        return count;
    }

}
