package com.javaDwarf.dataStructure.stacks;

public class StackCharImpl {

	int maxSize;
	char[] stackArr;
	int top;

	public StackCharImpl(int maxSize){
		this.maxSize = maxSize;
		stackArr =  new char[maxSize];
		top = -1;
	}

	public void push(char element) throws StackFullException{
		if(!isStackFull()){
			stackArr[++top] = element;
		}
		else{
			throw new StackFullException("Stack is full");
		}
	}

	public char pop() throws StackEmptyException{
		if(!isStackEmpty()){
			return stackArr[top--];
		}
		else{
			throw new StackEmptyException("Stack is empty");
		}
	}

	public char peek() throws StackEmptyException{
		if(top != -1){
			return stackArr[top];
		}
		else{
			throw new StackEmptyException("Stack is empty");
		}
	}

	public boolean isStackEmpty(){
		return (top == -1);
	}

	public boolean isStackFull(){
		return (top == stackArr.length-1);
	}

	public char match(char c) throws MatchingBracketException, StackEmptyException {
		char ch;
		if(this.isStackEmpty()){
			throw new MatchingBracketException("Matching Bracket Exception");
		}
		else{
			switch(c){
			case ')': {
				if(this.peek()=='('){
					ch = this.pop();
				}
				else{
					throw new MatchingBracketException("Matching Bracket Exception");
				}
				break;
			}
			case ']': {
				if(this.peek()=='['){
					ch = this.pop();
				}
				else{
					throw new MatchingBracketException("Matching Bracket Exception");
				}
				break;
			}
			case '}':{
				if(this.peek()=='{'){
					ch = this.pop();
				}
				else{
					throw new MatchingBracketException("Matching Bracket Exception");
				}
				break;
			}
			default:{
				ch='\0';
			}
			}
		}
		return ch;
	}
}
