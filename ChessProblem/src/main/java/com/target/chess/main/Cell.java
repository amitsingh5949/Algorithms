package com.target.chess.main;


import com.target.chess.pieces.Piece;



/**
 * There are total of 64 cells that together makes up the Chess Board
 *
 */
public class Cell implements Cloneable{
	
	private static final long serialVersionUID = 1L;
	private Piece piece;
	int x,y;                             
	
	public Cell(int x,int y,Piece p)
	{		
		this.x=x;
		this.y=y;
	    if(p!=null)
		 setPiece(p);
	}
	
	public Cell(Cell cell) throws CloneNotSupportedException
	{
		this.x=cell.x;
		this.y=cell.y;
		if(cell.getpiece()!=null)
		{
			setPiece(cell.getpiece().getcopy());
		}
		else
			piece=null;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece p)    
	{
		piece=p;
	}
	
	public void removePiece()      
	{
			piece=null;
	}
	
	
	public Piece getpiece()   
	{
		return this.piece;
	}
	
}