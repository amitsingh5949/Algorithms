package com.javadwarf.gfg;

class Pos implements Comparable<Pos>{
	public int x,y, value;
	public Pos(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value =value;
	}
	@Override
	public int compareTo(Pos o) {
		return Integer.compare(this.value, o.value);
	}
	@Override
	public String toString() {
		return value+"";
	}
}