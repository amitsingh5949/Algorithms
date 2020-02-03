package zappos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4 {

	public static void main(String[] args) throws Exception{

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {

			int len = Integer.parseInt(bufferedReader.readLine().trim());

			char[][] maze = new char[len][];

			for(int i= 0; i<maze.length; i++) {
				maze[i]  = bufferedReader.readLine().trim().toCharArray();
			}

			System.out.println(getPath(maze));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	static StringBuffer res = null;

	public static String getPath(char[][] maze) {

		res = new StringBuffer();

		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[i].length; j++) {

				if(maze[i][j] == 'S') {
					boolean[][] visited = new boolean[maze.length][maze[0].length];
					visited[i][j] = true;
					dfs(maze, i, j, visited, new StringBuffer());
				}
			}
		}

		return res.toString();

	}

	public static void dfs(char[][] matrix, int x, int y , boolean[][] visited, StringBuffer sb) {

		if(matrix[x][y] == 'F') {

			if(res != null || res.length() ==0 ) {
				res = new StringBuffer(sb);
				return;
			}
		}

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		for(int i=0; i<xArr.length; i++) {

			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew>=0 && xNew<matrix.length && 
					yNew >=0 && yNew<matrix[xNew].length &&
					!visited[xNew][yNew] && (matrix[xNew][yNew] == '+' || matrix[xNew][yNew] == 'F') ) {

				visited[xNew][yNew] = true;
				if(i == 0) {
					sb.append("L");
				}
				else if(i == 1) {
					sb.append("U");
				}
				else if(i == 2) {
					sb.append("D");
				}
				else if(i == 3) {
					sb.append("R");
				}

				dfs(matrix, xNew, yNew, visited, sb);

				sb.deleteCharAt(sb.length()-1);
				visited[xNew][yNew] = false;
			}
		}

	}

}
