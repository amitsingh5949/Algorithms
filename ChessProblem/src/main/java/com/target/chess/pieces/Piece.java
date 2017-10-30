package com.target.chess.pieces;

import java.util.ArrayList;

import com.target.chess.main.Cell;

public abstract class Piece implements Cloneable{

	private int color;
	private String id=null;
	protected ArrayList<Cell> possiblemoves = new ArrayList<Cell>();  
	public abstract ArrayList<Cell> possibleMoves(Cell pos[][],int x,int y);  
	
	public void setId(String id)
	{
		this.id=id;
	}
	
	public void setColor(int c)
	{
		this.color=c;
	}
	
	
	public String getId()
	{
		return id;
	}
	
	public int getcolor()
	{
		return this.color;
	}
	
	public Piece getcopy() throws CloneNotSupportedException
	{
		return (Piece) this.clone();
	}
}