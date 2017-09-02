package com.javaDwarf.dataStructure.stacks;

public class StackImpl {

	int maxSize;
	int[] stackArr;
	int top;

	public StackImpl(int maxSize){
		this.maxSize = maxSize;
		stackArr =  new int[maxSize];
		top = -1;
	}
	
	public void push(int element) throws StackFullException{
		if(!isStackFull()){
			stackArr[++top] = element;
		}
		else{
			throw new StackFullException("Stack is full");
		}
	}
	
	public int pop() throws StackEmptyException{
		if(!isStackEmpty()){
			return stackArr[top--];
		}
		else{
			throw new StackEmptyException("Stack is empty");
		}
	}
	
	public int peek() throws StackEmptyException{
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
}
