package gs.amit;

import java.util.Stack;

public class Bracket {

	public static void main(String[] args) {

	}
	
	public static String parenthesisChecker(String s){

		boolean match = false;
		Stack<Character> stack = null;
		char currentChar ='\0';

		if(s.length() == 0){
			return "NO";
		}
		else{
			stack = new Stack<>();
			outer : for(int i=0; i<s.length(); i++){

				currentChar = s.charAt(i);
				switch(currentChar){
				case '{': case'[': case'(':{
					stack.push(currentChar);
					break;
				}
				case ')': case ']': case '}':{
					match = matchParenthesis(stack,currentChar);
					if(!match){
						break outer;
					}
					else{
						break;
					}
				}
				}
			}
		}
		if(!stack.isEmpty()){
			return "NO";
		}
		return match?"YES":"NO";

	}

	public static boolean matchParenthesis(Stack<Character> stack,char c)  {
		boolean  match=  false;
		if(stack.isEmpty()){
			return false;
		}
		else{
			switch(c){
			case ')': {
				if(stack.peek()=='('){
					stack.pop();
					match=  true;
				}
				break;
			}
			case ']': {
				if(stack.peek()=='['){
					stack.pop();
					match=  true;
				}
				break;
			}
			case '}':{
				if(stack.peek()=='{'){
					stack.pop();
					match=  true;
				}
				break;
			}
			}
		}
		return match;
	}

}
