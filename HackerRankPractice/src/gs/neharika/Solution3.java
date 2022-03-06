package gs.neharika;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3 {
	
	public static  void main(String[] args) {
		System.out.println(new Date().toString());
		//System.out.println(new Solution3().meanderingArray(Arrays.asList(new Integer[] {7,5,2,7,8,-2,25,25})));
		//System.out.println(new Solution3().meanderingArray(Arrays.asList(new Integer[] {-5,-1,1,2,3})));

	}
	
	public  List<Integer> meanderingArray(List<Integer> unsorted){
		
		List<Integer> res = new ArrayList<>();
		
		Collections.sort(unsorted);
		
		int i = 0 ;
		int j = unsorted.size()-1;
		
		while(i<=j) {
			if(i==j) {
				res.add(unsorted.get(i));
				break;
			}
			res.add(unsorted.get(j));
			res.add(unsorted.get(i));
			i++;
			j--;
			
		}
		
		return res;
		
	}

}
