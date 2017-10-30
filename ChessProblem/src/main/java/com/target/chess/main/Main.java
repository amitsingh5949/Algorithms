package com.target.chess.main;

import java.util.Scanner;

/**
 * @author Amit Singh
 *
 */

public class Main
{
	static int color=0;
	static Board board =  new Board();
	static boolean isCheckMate = false;

	public static void main(String[] args){

		System.out.println(board.printBoardState());
		Scanner scan = null;
		String input = null;
		try {
			scan = new Scanner(System.in);
			
			outer : while(!isCheckMate){
				if(color == 0){
					System.out.println("White Player Turn ! Please enter your move");
				}
				else{
					System.out.println("Black Player Turn ! Please enter your move");
				}

				input = scan.next();
				try {
					board.move(input);
				} catch (Exception e) {
					continue outer;
				}
				isCheckMate = board.checkmate();
				if(color == 0){
					color = 1;
				}
				else{
					color = 0;
				}
				System.out.println(board.printBoardState());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			scan.close();
		}


	}



}
