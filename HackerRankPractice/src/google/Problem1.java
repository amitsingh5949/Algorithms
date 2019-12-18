package google;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) {

	}
	
	public static String solution(String[] A) {
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		for(String room : A) {
			String cur = room.substring(1);
			if(room.charAt(0) == '+') {
				map.put(cur, map.getOrDefault(cur, 0) + 1);
				 max= Math.max(max, map.get(cur));
			}
		}
		String minstring = "9Z";
		for(String room : A) {
			String cur  = room.substring(1);
			if(map.get(cur) == max) {
				if(isSmaller(cur, minstring)) {
					minstring = cur;
				}
			}
		}
		return max > 0 ? minstring : null;
	}
	
	public static boolean isSmaller(String a, String b) {
		if(a.equals(b))
			return true;
		int numa = (int)(a.charAt(0) - '0');
		int numb = (int)(b.charAt(0) - '0');
		if(numa < numb)
			return true;
		else if(numa > numb)
			return false;
		else {
			char ca = a.charAt(a.length() - 1);
			char cb = b.charAt(b.length() - 1);
			if(ca <= cb)
				return true;
			return false;			
		}
		

	}

}
