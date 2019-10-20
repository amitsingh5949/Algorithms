package gs.praveen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem1 {

	public static void main(String[] args) {
		Integer[][] matrix = {
				{80, 96, 81, 77}, 
				{78, 71, 93, 75 },
				{71, 98, 70, 95 },
				{80, 96, 89, 77}
		};

		List<List<Integer>> values = new ArrayList<>();

		for(Integer[] x : matrix) {
			List<Integer> a = Arrays.asList(x);
			values.add(a);
		}

		System.out.println(new Problem1().rankIndex(values, 3));

	}

	public int rankIndex(List<List<Integer>> values, int rank) {

		List<Integer> sum = new ArrayList<>();
		List<Integer> sumSorted = new ArrayList<>();

		for(List<Integer> l : values) {
			int sumCurr = 0;
			for(Integer i :l) {
				sumCurr += i;
			}
			sum.add(sumCurr);
			sumSorted.add(sumCurr);
		}

		Collections.sort(sumSorted, Collections.reverseOrder());

		int res = 0;

		boolean[] visited = new boolean[sum.size()];

		for(int i =0; i<rank;i++) {

			int currMark = sumSorted.get(i);

			for(int j= 0; j<sum.size(); j++) {
		
				if(sum.get(j) == currMark && !visited[j]) {
					visited[j] = true;	
					if(i==rank-1) {
						res = j;
					}
					break;
				}
			}
		}
		return res;
	}
}
