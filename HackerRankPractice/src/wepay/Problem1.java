package wepay;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1 {

	public static boolean arraySum(List<Integer> inputs, List<Integer> tests) {

		Set<Integer> set = new HashSet<>(tests);

		for(int i=0; i<inputs.size(); i++) {
			for(int j=0; j<inputs.size(); j++) {
				if(set.contains(inputs.get(i) + inputs.get(j))) {
					return true;
				}
			}
		}
		return false;
	}

}
