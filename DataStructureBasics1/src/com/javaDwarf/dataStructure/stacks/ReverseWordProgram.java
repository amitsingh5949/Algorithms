package com.javaDwarf.dataStructure.stacks;

import java.util.Scanner;

public class ReverseWordProgram {

	public static void main(String[] args) {
		System.out.println("Please enter a word that needs to be reversed");
		String word = "";
		Scanner scanner = new Scanner(System.in); 
		word = scanner.nextLine();
		scanner.close();
		if(word.length() == 0){
			System.out.println("Word cannot be blank");
		}
		else{
			StackImpl stack = new StackImpl(word.length());

			for(int i=0; i<word.length(); i++){
				try {
					stack.push(word.charAt(i));
				} catch (StackFullException e) {
					System.out.println(e.getMessage());
				}
			}

			System.out.println("The word is : " + word);
			System.out.print("The reversed word is : " );

			while(!stack.isStackEmpty()){
				try {
					System.out.print((char)stack.pop());
				} catch (StackEmptyException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
