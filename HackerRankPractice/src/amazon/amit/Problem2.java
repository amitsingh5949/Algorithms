package amazon.amit;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Problem2 {

	public static void main(String[] args) {

	}
	
	int minimumDays(int rows, int columns, List<List<Integer> > grid)
    {
        int count = 0;
        if(grid== null || grid.size() == 0) return count;
		Queue<Cell> q = new LinkedList<>();

		boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];

		boolean allZeros =  true;

		for(int i=0; i<grid.size(); i++) {
			for(int j=0; j<grid.get(0).size(); j++) {
				if(grid.get(i).get(j) == 1) {
					q.add(new Cell(i,j));
					visited[i][j] = true;
					allZeros = false;
				}
			}
		}
		
		if(allZeros) return -1;

		q.add(null);

		while(q.size() > 1) {

			Cell cell = q.poll();

			if(cell == null) {
				q.add(null);
				count++;
				continue;
			}

			int x = cell.x;
			int y = cell.y;

			int[] xArr = {0,-1,1,0};
			int[] yArr = {-1,0,0,1};

			for(int i=0; i<xArr.length; i++) {

				int xNew = x + xArr[i];
				int yNew = y + yArr[i];

				if(xNew >= 0 && xNew < grid.size() && yNew >=0 && yNew < grid.get(0).size()  &&
						grid.get(xNew).get(yNew) != 1 && !visited[xNew][yNew]) {
					visited[xNew][yNew] = true;
					q.add(new Cell(xNew, yNew));
				}
			}
		}

		return count;
    }

}


class Cell{

	public int x ;
	public int y;

	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}