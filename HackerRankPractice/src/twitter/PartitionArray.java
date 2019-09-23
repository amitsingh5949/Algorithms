package twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionArray {

	public static void main(String[] args) {
		int[] arr = {4,8,8,8,6,4};
		List<Integer> x = new ArrayList<>();
		for(int temp : arr) {
			x.add(temp);
		}
		
		System.out.println(solve(3, x));
	}

	public static String solve(int k, List<Integer> numbers) {

		String result = "Yes";

		if(numbers.size()%k != 0) return "No";

		Map<Integer, Integer> map = new HashMap<>();

		for(Integer i : numbers) {
			int x = map.getOrDefault(i, 0);
			if(x == numbers.size()/k) {
				return "No";
			}
			map.put(i, ++x);
		}

		return result;
	}

}
