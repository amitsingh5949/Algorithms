package ancestry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<String> usernamesSystem(List<String>  u){
		List<String> res = new ArrayList<String>();
		
		Map<String, Integer> map = new HashMap<>();
		
		for(String name : u) {
			
			if(!map.containsKey(name)){
				map.put(name, 1);
				res.add(name);
			}
			else {
				int count = map.get(name);
				res.add(name+count);
				map.put(name, count+1);
			}
		}
		
		return res;
	}

}
