package gs.sunny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {

	public static void main(String[] args) {
		Integer[] a = new Integer[]{0,1,0,0};
		List<Integer> l1 = Arrays.asList(a);
		Integer[] b = new Integer[]{0,0,0,0};
		List<Integer> l2 = Arrays.asList(b);


		List<List<Integer>> grid = new ArrayList<List<Integer>>();
		grid.add(l1);
		grid.add(l2);

		String[] rule = new String[9];
		Arrays.fill(rule, "dead");
		rule[1] = "alive";
		rule[5] = "alive";
		System.out.println(gridGame(grid, 2, Arrays.asList(rule)));
	}

	public static List<List<Integer>> gridGame(List<List<Integer>> grid, int k, List<String> rules){
		for(int i=0; i<k;i++) {
			changeGrid(grid, rules);
		}
		return grid;

	}

	public static void changeGrid(List<List<Integer>> grid, List<String> rules){

		int n = grid.size();
		int m = grid.get(0).size();

		int[][] aliveNeighbourCount = new int[n][m];

		for(int i=0 ; i<n; i++) {
			for(int j =0 ; j<m; j++) {
				aliveNeighbourCount[i][j] = getAliveNeighbourCount(grid, i, j);
			}
		}

		Set<Integer> rulesIn = new HashSet<Integer>();
		for(int i=0; i<rules.size(); i++) {
			if(rules.get(i).equalsIgnoreCase("alive")){
				rulesIn.add(i);
			}
		}

		for(int i=0 ; i<n; i++) {
			for(int j =0 ; j<m; j++) {
				if(rulesIn.contains(aliveNeighbourCount[i][j])) {
					grid.get(i).set(j, 1);
				}
				else {
					grid.get(i).set(j, 0);
				}
			}
		}

	}

	public static int getAliveNeighbourCount(List<List<Integer>> grid, int x, int y) {

		int count = 0;

		int[] xArr = {-1,0,1,-1,1,-1,0,1};
		int[] yArr = {-1,-1,-1,0,0,1,1,1};

		for(int i =0; i<xArr.length; i++) {
			int xNew = x + xArr[i]  ;
			int yNew = y + yArr[i]  ;
			if( xNew>=0 && xNew<grid.size() &&
					yNew >=0 && yNew< grid.get(0).size() 
					&& grid.get(xNew).get(yNew)==1) {
				count +=1;
			}
		}
		return count;
	}

}
