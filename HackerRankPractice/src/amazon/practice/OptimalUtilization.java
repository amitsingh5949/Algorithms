package amazon.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class OptimalUtilization {



	public static void main(String...s) {
		int[][][] As = {
				{{1, 2}, {2, 4}, {3, 6}},
				{{1, 3}, {2, 5}, {3, 7}, {4, 10}},
				{{1, 8}, {2, 7}, {3, 14}},
				{{1, 8}, {2, 15}, {3, 9}}
		};
		int[][][] Bs = {
				{{1, 2}},
				{{1, 2}, {2, 3}, {3, 4}, {4, 5}},
				{{1, 5}, {2, 10}, {3, 14}},
				{{1, 8}, {2, 11}, {3, 12}}
		};

		int[] targets = {7, 10, 20};

		for (int i=0; i<3; i++) {
			System.out.println(compute(As[i], Bs[i], targets[i]).toString());
			System.out.println(optimalUtil(As[i], Bs[i], targets[i]).toString());
			System.out.println("***");
		}
	}

	private static List<List<Integer>> optimalUtil(int[][] a, int[][] b, int target) {
		List<List<Integer>> res = new ArrayList<>();

		Arrays.parallelSort(a, (x,y) -> Integer.compare(x[1], y[1]));
		Arrays.parallelSort(b, (x,y) -> Integer.compare(x[1], y[1]));

		int start = 0;
		int end = b.length-1;

		int maxSum  = 0;

		while(start<a.length && end>=0) {

			int currSum = a[start][1] + b[end][1];

			if(currSum > target) {
				end--;
			}
			else {
				if(currSum > maxSum) {
					res.clear();
					List<Integer> temp = new ArrayList<>();
					temp.add(start+1);
					temp.add(end+1);
					res.add(temp);
					maxSum = currSum;
				}
				else if(currSum == maxSum) {
					List<Integer> temp = new ArrayList<>();
					temp.add(start+1);
					temp.add(end+1);
					res.add(temp);
				}
				start++;
			}
		}
		return res;
	}

// Brute force o(n^2)

	private static List<List<Integer>> compute(int[][] a, int[][] b, int target) {
		TreeMap<Integer, List<List<Integer>>> tree = new TreeMap<>();
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<b.length; j++) {
				int sum = a[i][1] + b[j][1]; 
				if (sum <= target) {
					List<List<Integer>> list = tree.computeIfAbsent(sum, (k) -> new ArrayList<>());
					list.add(Arrays.asList(a[i][0], b[j][0]));
				}
			}
		}
		return tree.floorEntry(target).getValue();
	}

}
