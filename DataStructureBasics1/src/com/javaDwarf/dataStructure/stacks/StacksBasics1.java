package com.javaDwarf.dataStructure.stacks;

public class StacksBasics1 {

	public static void main(String[] args) {
		StackImpl stack = new StackImpl(10);

		for(int i= 0; i<=10;i++){
			try {
				stack.push((int) (Math.random()*100));
			} catch (StackFullException e) {
				System.out.println(e.getMessage());
			}
		}

		try {
			System.out.println(stack.peek());
		} catch (StackEmptyException e) {
			System.out.println(e.getMessage());
		}

		while(!stack.isStackEmpty()){
			try {
				System.out.println(stack.pop());
			} catch (StackEmptyException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
