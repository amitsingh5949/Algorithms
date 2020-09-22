package robinhood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Problem4 {

	public static void main(String[] args) {

	}

	public static Long[] matrixQueries(int n, int m, int[][] queries) {

		List<Long> l = new ArrayList<>();
		Stack<int[]> s = new Stack<>();
		addelements(s);
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();

		for(int[] query : queries) {
			if(query[0] == 0) {
				l.add(min(s,rows,cols));
			}
			else if(query[0] == 1) {
				rows.add(query[1]);
			}
			else if(query[0] == 2) {
				cols.add(query[1]);
			}
		}

		return l.toArray(new Long[l.size()]);
	}
	
	public static Stack<int[]> addelements( Stack<int[]> s){

		return s;
	}

	public Stack<int[]> addelements(int i, int j, Stack<int[]> s){

		return s;
	}

	public static long min(Stack<int[]> s, Set<Integer> rows, Set<Integer> cols) {
		while((!rows.isEmpty() && rows.contains(s.peek()[0])) || (!cols.isEmpty() && cols.contains(s.peek()[1]))) {
			s.pop();
		}
		return s.peek()[0]*s.peek()[1];
	}

}


