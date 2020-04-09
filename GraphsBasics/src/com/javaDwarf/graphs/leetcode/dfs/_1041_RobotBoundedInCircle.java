package com.javaDwarf.graphs.leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

public class _1041_RobotBoundedInCircle {

	public static void main(String[] args) {
		System.out.println(new _1041_RobotBoundedInCircle().isRobotBounded("GGLLGG"));
		System.out.println(new _1041_RobotBoundedInCircle().isRobotBounded("GG"));
		System.out.println(new _1041_RobotBoundedInCircle().isRobotBounded("GL"));
	}

	public boolean isRobotBounded(String instructions) {

		Map<Character, Character> left = new HashMap<>();
		left.put('N', 'W');
		left.put('S', 'E');
		left.put('E', 'N');
		left.put('W', 'S');

		Map<Character, Character> right = new HashMap<>();
		right.put('N', 'E');
		right.put('S', 'W');
		right.put('E', 'S');
		right.put('W', 'N');

		char dir = 'N';
		int x = 0;
		int y = 0;

		for (int i = 0; i < instructions.length(); i++) {

			char ch = instructions.charAt(i);

			if(ch == 'L') {
				dir = left.get(dir);
			}
			else if(ch == 'R') {
				dir = right.get(dir);
			}

			else if(ch == 'G') {
				if(dir == 'N') {
					y++;
				}
				else if(dir == 'S') {
					y--;
				}
				else if(dir == 'E') {
					x++;
				}
				else if(dir == 'W') {
					x--;
				}
			}
		}
		return (y == 0 && x == 0) || dir != 'N';
	}

}
