package com.target.chess.pieces;

import java.util.ArrayList;

import com.target.chess.main.Cell;

public class King extends Piece{
	
	private int x,y; 
	
	public King(String i,int c,int x,int y)
	{
		setx(x);
		sety(y);
		setId(i);
		setColor(c);
	}
	
	public void setx(int x)
	{
		this.x=x;
	}
	public void sety(int y)
	{
		this.y=y;
	}
	public int getx()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
	public ArrayList<Cell> possibleMoves(Cell state[][],int x,int y)
	{
		possiblemoves.clear();
		int posx[]={x,x,x+1,x+1,x+1,x-1,x-1,x-1};
		int posy[]={y-1,y+1,y-1,y,y+1,y-1,y,y+1};
		for(int i=0;i<8;i++)
			if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
				if((state[posx[i]][posy[i]].getpiece()==null||state[posx[i]][posy[i]].getpiece().getcolor()!=this.getcolor()))
					possiblemoves.add(state[posx[i]][posy[i]]);
		return possiblemoves;
	}
	
}