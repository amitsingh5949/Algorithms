package com.javadwarf.string.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _68_TextJustification {

	public static void main(String[] args) {

		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(new _68_TextJustification().fullJustify(words, 16));

		String[] words1 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		System.out.println(new _68_TextJustification().fullJustify(words1, 20));

		String[] words2 = {"What","must","be","acknowledgment","shall","be"};
		System.out.println(new _68_TextJustification().fullJustify(words2, 16));
		
		String[] words3 = {"My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
		System.out.println(new _68_TextJustification().fullJustify(words3, 20));
		

	}

	List<String> res = null;

	public List<String> fullJustify(String[] words, int maxWidth) {
		

		res = new ArrayList<String>();

		int start = 0;

		while(start < words.length) {
			int[] arr = getLastWordIndexandLength(start, words, maxWidth);
			int end = arr[0];
			int len = arr[1];
			int numOfSpaces = maxWidth - len;

			String temp = "";
			if(end - start == 0) {
				temp += words[start] + addSpace(numOfSpaces);
			}
			else if(end == words.length-1) {
				for(int i=start;i<end; i++) {
					temp += words[i] + " ";
				}
				temp += words[end]+addSpace(numOfSpaces - (end-start));
			}
			else {
				int constantSpace = numOfSpaces/(end-start);
				int extraSpace = numOfSpaces%(end-start);
				for(int i=start;i<end; i++) {
					temp += words[i] + addSpace(constantSpace);
					if(extraSpace !=0) {
						temp += " ";
						extraSpace--;
					}
				}
				temp += words[end];
			}
			res.add(temp);
			start = end+1;
		}
		return res;
	}

	public int[] getLastWordIndexandLength(int start, String[] words , int maxWidth){
		int curr = start;
		int len = 0;
		int tempLen = 0;
		for(curr = start; curr<words.length; curr++) {
			if(tempLen + words[curr].length() > maxWidth) {
				break;
			}
			len += words[curr].length();
			tempLen += (words[curr].length() + 1);
		}
		return new int[] {--curr, len};
	}

	public String addSpace(int num) {
		String res = "";
		for(int i=0; i<num;i++) {
			res += " ";
		}
		return res;
	}

}
