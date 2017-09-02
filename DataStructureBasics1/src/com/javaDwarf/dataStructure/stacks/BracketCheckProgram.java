package com.javaDwarf.dataStructure.stacks;

import java.util.Scanner;

public class BracketCheckProgram {

	public static void main(String[] args) {
		System.out.println("Please enter a string that needs to be checked for brackets");
		String word = "";
		char ch='\0';
		int errorIndex=0;
		char currentChar ='\0';
		StackCharImpl stack = null;
		boolean match=true; 
		Scanner scanner = new Scanner(System.in); 
		word = scanner.nextLine();
		scanner.close();
		if(word.length() == 0){
			System.out.println("Word cannot be blank");
		}
		else{
			stack = new StackCharImpl(word.length());
			outer : for(int i=0; i<word.length(); i++){

				currentChar = word.charAt(i);
				switch(currentChar){
				case '{': case'[': case'(':{
					try {
						stack.push(currentChar);
					} catch (StackFullException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case ')': case ']': case '}':{
					try {
						ch = stack.match(currentChar);
						break;
					} catch (MatchingBracketException | StackEmptyException e) {
						System.out.println(e.getMessage());
						match=false;
						errorIndex=i;
						break outer;
					}
				}
				default:{
					break;
				}
				}
			}
		}
		if(stack.isStackEmpty()){
			if(match){
				System.out.println("brackets are in order");
			}
			else{
				System.out.println("brackets are not in order and the issue is with "+ currentChar +" at "+ errorIndex);
			}
		}
		else{
			try {
				System.out.println("brackets are not in order and the issue is with "+ stack.peek());
			} catch (StackEmptyException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
/*test cases
 * a
 * a[
 * a[]
 * a[b]
 * ab]
 * a{b{c[de(f)xy]t}}
 * a{b{c[de(f)xy]t}
 * a{b{c[de(f)xy]t}}]
 * a{b{c[de(f)xy]t(pc)zz}}
 * a{b{c[de(f)xy]t(pczz}}
 */
