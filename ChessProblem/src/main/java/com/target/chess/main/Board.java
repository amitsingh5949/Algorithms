package com.target.chess.main;

import java.util.ArrayList;

import com.target.chess.pieces.Bishop;
import com.target.chess.pieces.King;
import com.target.chess.pieces.Knight;
import com.target.chess.pieces.Pawn;
import com.target.chess.pieces.Piece;
import com.target.chess.pieces.Queen;
import com.target.chess.pieces.Rook;
import com.target.chess.util.ChessUtil;


public class Board {

	private static Rook R01,R02,r01,r02;
	private static Knight N01,N02,n01,n02;
	private static Bishop B01,B02,b01,b02;
	private static Pawn P[],p[];
	private static Queen Q,q;
	private static King K,k;
	private Cell boardState[][];

	public  Board() {
		initialize();
	}

	private void initialize() {
		Cell cell;
		Piece Pi;
		boardState=new Cell[8][8];

		R01=new Rook("R",0);
		R02=new Rook("R",0);
		r01=new Rook("r",1);
		r02=new Rook("r",1);
		N01=new Knight("N",0);
		N02=new Knight("N",0);
		n01=new Knight("n",1);
		n02=new Knight("n",1);
		B01=new Bishop("B",0);
		B02=new Bishop("B",0);
		b01=new Bishop("b",1);
		b02=new Bishop("b",1);
		Q=new Queen("Q",0);
		q=new Queen("q",1);
		K=new King("K",0,7,3);
		k=new King("k",1,0,3);
		P=new Pawn[8];
		p=new Pawn[8];
		for(int i=0;i<8;i++)
		{
			P[i]=new Pawn("P",0);
			p[i]=new Pawn("p",1);
		}

		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{	
				Pi=null;
				if(i==0&&j==0)
					Pi=r01;
				else if(i==0&&j==7)
					Pi=r02;
				else if(i==7&&j==0)
					Pi=R01;
				else if(i==7&&j==7)
					Pi=R02;
				else if(i==0&&j==1)
					Pi=n01;
				else if (i==0&&j==6)
					Pi=n02;
				else if(i==7&&j==1)
					Pi=N01;
				else if (i==7&&j==6)
					Pi=N02;
				else if(i==0&&j==2)
					Pi=b01;
				else if (i==0&&j==5)
					Pi=b02;
				else if(i==7&&j==2)
					Pi=B01;
				else if(i==7&&j==5)
					Pi=B02;
				else if(i==0&&j==3)
					Pi=k;
				else if(i==0&&j==4)
					Pi=q;
				else if(i==7&&j==3)
					Pi=K;
				else if(i==7&&j==4)
					Pi=Q;
				else if(i==1)
					Pi=p[j];
				else if(i==6)
					Pi=P[j];
				cell=new Cell(i,j,Pi);
				boardState[i][j]=cell;
			}
	}

	public  void move(String input) throws Exception{

		String pieceId = "";
		int prevX = -1;
		int prevY =-1;
		int newX = -1;
		int newY = -1;
		ArrayList<Cell> possibleMoves = null;
		if(input.length() == 5){
			pieceId = Character.valueOf(input.charAt(0)).toString();
			prevX = Character.getNumericValue(input.charAt(1))-1;
			prevY = ChessUtil.getRowIndex(input.charAt(2));
			newX = Character.getNumericValue(input.charAt(3))-1;
			newY = ChessUtil.getRowIndex(input.charAt(4));
		}

		Piece p = this.boardState[prevX][prevY].getpiece();
		if(p != null && p.getId().equalsIgnoreCase(pieceId) ){
			possibleMoves = p.possibleMoves(this.boardState, prevX, prevY);
			Cell newcell = new Cell(newX, newY,p);
			if(possibleMoves.size() > 0 && possibleMoves.contains(newcell)){
				this.boardState[prevX][prevY].setPiece(null);
				this.boardState[newX][newY].setPiece(p);
			}
			else{
				throw new Exception();
			}
		}
		else{
			throw new Exception();
		}
	}

	public String printBoardState(){

		StringBuilder sb = new StringBuilder(); 
		boolean flag = false;

		for(int i=0;i<8;i++){
			if(flag){
				sb.append("|");
			}
			else{
				flag = true;
			}
			int emptyCellCount = 0;	
			for(int j=0;j<8;j++)
			{
				Piece p = boardState[i][j].getpiece();
				if(p != null){
					if(emptyCellCount == 0){
						sb.append(p.getId());
					}
					else{
						sb.append(Integer.valueOf(emptyCellCount).toString()).append(p.getId());
					}
					emptyCellCount = 0;	
				}
				else{
					emptyCellCount++;
				}
			}
			if(emptyCellCount != 0){
				sb.append(Integer.valueOf(emptyCellCount).toString());
			}
		}
		return sb.toString();
	}


	public boolean checkmate(){

		int kingCount = 0;
		boolean isCheckmate = true;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++)
			{
				Piece p = this.boardState[i][j].getPiece();
				if(p!=null && p instanceof King){
					kingCount++;
				}
				if(kingCount == 2){
					isCheckmate =  false;
					break;
				}
				
			}
		}
		return isCheckmate;
	}
	
	
}
