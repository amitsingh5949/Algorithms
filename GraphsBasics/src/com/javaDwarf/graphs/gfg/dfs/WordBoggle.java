package com.javaDwarf.graphs.gfg.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordBoggle {

	private static String[] dict = null;
	private static int[] xArr = {-1,0,1,-1,1,-1,0,1};
	private static int[] yArr = {-1,-1,-1,0,0,1,1,1};
	private static List<String> list = null;

	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int numOfTest = s.nextInt();

		char[][] matrix = null;
		for(int i=0; i<numOfTest; i++) {
			int size = s.nextInt();
			dict = new String[size];
			list = new ArrayList<>();
			for(int p=0; p<size; p++) {
				dict[p] = s.next();
			}
			int row = s.nextInt();
			int col = s.nextInt();
			matrix = new char[row][col];
			for(int x = 0; x< row; x++) {
				for(int y = 0; y< col; y++) {
					matrix[x][y] = s.next().charAt(0);
				}
			}
			wordBoggle(matrix,row,col);
			System.out.println();
		}
		s.close();
	}

	private static void wordBoggle(char[][] matrix, int row, int col) {
		boolean[][] visited = new boolean[row][col];
		for(int x = 0; x< row; x++) {
			for(int y = 0; y< col; y++) {
				visited[x][y] = true;
				dfs(new Pos(x,y), new StringBuffer(matrix[x][y]+""), matrix, visited); 
				visited[x][y] = false;
			}
		}
		Collections.sort(list);
		if(list.size()==0) {
			System.out.print(-1);
		}
		else {
			list.stream().forEach(e -> System.out.print(e+" "));
		}
	}

	private static void dfs(Pos p, StringBuffer sb, char[][] matrix, boolean[][] visited) {
		int result = wordLookup(sb.toString());
		if(result==2) {
			if(!list.contains(sb.toString())) {
				list.add(sb.toString());
			}
		}
		else if(result==0) {
			return;
		}

		for(int i=0; i<xArr.length; i++) {
			if(p.x+xArr[i]>=0 && p.x+xArr[i]< matrix.length &&
					p.y+yArr[i]>=0 && p.y+yArr[i]< matrix[p.x+xArr[i]].length &&
					!visited[p.x+xArr[i]][p.y+yArr[i]]) {
				visited[p.x+xArr[i]][p.y+yArr[i]] = true;
				sb.append(matrix[p.x+xArr[i]][p.y+yArr[i]]);
				dfs(new Pos(p.x+xArr[i],p.y+yArr[i]), sb, matrix, visited);
				sb.deleteCharAt(sb.length()-1);
				visited[p.x+xArr[i]][p.y+yArr[i]] = false;
			}
		}
	}

	private static int wordLookup(String str) {
		int result = 0;
		for(int i=0; i<dict.length; i++) {
			String temp = dict[i];
			int x = 1;
			if(str.length()<=temp.length()) {
				for(int k=0; k<str.length();k++) {
					if(temp.charAt(k)!=str.charAt(k)) {
						x=0;
						break;
					}
				}
			}
			else {
				x=0;
			}
			if (x == 1) {
				if(str.length()==temp.length()) {
					x = 2;
				}
				result = x;
			}
			if(result==2) {
				return result;
			}
		}
		return result;
	}
}
