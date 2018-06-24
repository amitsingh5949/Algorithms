package com.javadwarf.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static List<String> dictionary = null;

	public static void main(String[] args){
		/*String s1 = null;
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			dictionary = new ArrayList<>();
			for(int j=0; j<size; j++){
				dictionary.add(in.next().toLowerCase());
			}
			s1 = in.next().toLowerCase();
			System.out.println(wordBreak(s1));
		}
		in.close();*/
		dictionary = Arrays.asList(new String[]{"i","like","dogs"});
		System.out.println(wordBreak("ilikes"));
	}


	public static int wordBreak(String a ){

		char[] c = a.toCharArray();
		boolean[][] matrix = new boolean[c.length][c.length]; 

		for(int k=0; k<matrix.length; k++){
			for(int i=0, j=k; j<matrix.length; i++,j++){
				if(i==j){
					matrix[i][j] = isWord(Character.valueOf(a.charAt(i)).toString());
				}
				else{
					if(isWord(a.substring(i,j+1))){
						matrix[i][j] = true;
					}
					else{
						boolean val = false;
						for(int x=i; x<j; x++){
							boolean temp = (matrix[i][x] && matrix[x+1][j]) ||
									(isWord(a.substring(i,x+1)) && isWord(a.substring(x+1,j+1)));
							if(temp) {
								val = true;
								break;
							}
						}
						matrix[i][j] = val;
					}
				}
			}	
		}
		return matrix[0][c.length-1]?1:0;  
	}

	public static boolean isWord(String s){
		return dictionary.contains(s.toLowerCase());
	}

}