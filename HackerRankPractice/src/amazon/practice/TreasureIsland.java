package amazon.practice;

import java.util.LinkedList;
import java.util.Queue;


public class TreasureIsland {

	public static void main(String[] args) {
		
		char[][] island = new char[][]{
			{'O', 'O', 'O', 'O'},
			{'D', 'O', 'D', 'O'},
			{'O', 'O', 'O', 'O'},
			{'X', 'D', 'D', 'O'}
	};
	int result = TreasureIsland.treasureIsland(island);
	System.out.println(result);

	}
	
	public static int treasureIsland(char[][] island) {
		
		int count = 0;
		
		boolean[][] visited = new boolean[island.length][island[0].length];
		
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0));
		q.add(null);
		
		while(q.size()>1) {
			Pos p = q.poll();
			
			if(p == null ) {
				count++;
				q.add(null);
				continue;
			}
			
			int x = p.x;
			int y = p.y;
			
			if(island[x][y] == 'X') {
				return count;
			}
			
			int[] xArr = {0,-1,1,0};
			int[] yArr = {-1,0,0,1};

			for(int i=0; i<xArr.length; i++) {

				int xNew = x + xArr[i];
				int yNew = y + yArr[i];

				if(xNew >= 0 && xNew < island.length && yNew >=0 && yNew < island[0].length  &&
						island[xNew][yNew] != 'D' && !visited[xNew][yNew]) {
					visited[xNew][yNew] = true;
					q.add(new Pos(xNew, yNew));
				}
			}
		}
		
		return count;
		
		
	}

}

class Pos{
	
	public int x, y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}