package com.javadwarf.disjointset.leetcode;

public class _200_NumberofIslands {

	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','0','0','0'}, 
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};


		System.out.println(numIslands(grid));
	}

	public static DisjointSet ds = null;
	public static int numIslands(char[][] grid) {// do not use of visited[][] matrix

		if(grid.length == 0) return 0;
		
		int[][] mat = new int[grid.length][grid[0].length];

		ds = new DisjointSet();

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {

				if(grid[i][j] == '1') {

					int v1 = uniqueCellID(i, j);
					mat[i][j] = v1;
					if(ds.map.get(v1)==null) {
						ds.makeSet(v1);
					}
					
					int[] xArr = { 0, -1, 1, 0};
					int[] yArr = { -1, 0, 0, 1};
					
					for(int k=0; k<xArr.length; k++){

						int xNew = i + xArr[k];
						int yNew = j + yArr[k];

						if(xNew >= 0 && xNew < grid.length
								&& yNew >= 0 && yNew < grid[xNew].length
								&& grid[xNew][yNew] == '1'){
							int v2 =uniqueCellID(xNew, yNew);
							mat[xNew][yNew] = v2;
							if(ds.map.get(v2)==null) {
								ds.makeSet(v2);
							}
							
							ds.union(v1,v2 );
						}
					}
				}
			}
		}


		for(int key : ds.map.keySet()) {
			ds.find(key);
		}
		
		int max = 0;
		for(DisjointSet.Node node : ds.map.values()) {
			if(node.data == node.parent.data) {
				max++;
			}
		}
		return max;
	}

	public static int uniqueCellID(int row, int col) {
		return (((row + col) * (row + col +1) ) /2 ) + col;
	}

}
