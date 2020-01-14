package genospace;

import java.util.Stack;

public class Problem2 {

	public static void main(String[] args) {

	}
	
	public boolean solution(String S) {
        boolean match = false;
		Stack<Character> stack = null;
		char currentChar ='\0';

		if(S.length() == 0){
			return true;
		}
		else{
			stack = new Stack<>();
			outer : for(int i=0; i<S.length(); i++){

				currentChar = S.charAt(i);
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
			return false;
		}
		return match;
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
