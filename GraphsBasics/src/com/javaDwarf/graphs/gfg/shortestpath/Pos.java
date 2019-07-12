package com.javaDwarf.graphs.gfg.shortestpath;

public class Pos implements Comparable<Pos> {
	int x,y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pos o) {
		int x1 =  (((this.x + this.y)*(this.x + this.y + 1))/2) + this.y;
		int x2 =  (((o.x + o.y)*(o.x + o.y + 1))/2) + o.y;
		return Integer.compare(x1, x2);
	}

}
