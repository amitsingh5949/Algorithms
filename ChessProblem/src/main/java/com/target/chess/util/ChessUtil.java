package com.target.chess.util;

public class ChessUtil {
	
	static public int getRowIndex(char c){
		
		int index = -1;
		
		switch(c){
		
		case  'a' :  case 'A' :{
			index = 0;
			break;
		}
		case  'b' :  case 'B' :{
			index = 1;
			break;
		}
		case  'c' :  case 'C' :{
			index = 2;
			break;
		}
		case  'd' :  case 'D' :{
			index = 3;
			break;
		}
		case  'e' :  case 'E' :{
			index = 4;
			break;
		}
		case  'f' :  case 'F' :{
			index = 5;
			break;
		}
		case  'g' :  case 'G' :{
			index = 6;
			break;
		}
		case  'h' :  case 'H' :{
			index = 7;
			break;
		}
		}
		return index;
	}

}
