package com.javadwarf.stackbasics.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class _341_FlattenNestedListIterator { }

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}


// Idea is fill stack from end till start and check if each element is integer or list, if list then from end till start fill it in stack
class NestedIterator implements Iterator<Integer> {

	Stack<NestedInteger> s = new Stack<>();

	public NestedIterator(List<NestedInteger> nestedList) {
		for(int i =nestedList.size()-1; i>=0; i--) {
			s.add(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		if(hasNext()) {
			return s.pop().getInteger();
		}
		return null;
	}

	@Override
	public boolean hasNext() {

		boolean result = false;

		while(!s.isEmpty()) {
			NestedInteger curr = s.peek();
			
			if(curr.isInteger()) {
				return true;
			}
			else {
				curr = s.pop();
				for(int i = curr.getList().size()-1; i>=0; i--) {
					s.add(curr.getList().get(i));
				}
			}
		}
		return result;
	}
}


/*
 * My idea was to have to two stacks one for list and other to maintain curr list index
 * 
 * 
 * class NestedIterator implements Iterator<Integer> {

	Stack<List<NestedInteger>>  nestedIntegerListStack = null;
	Stack<Integer>  indexStack = null;

	public NestedIterator(List<NestedInteger> nestedList) {
		nestedIntegerListStack = new Stack<>();
		indexStack = new Stack<>();
		if(nestedList!=null && nestedList.size()>0) {
			boolean emptylist = true;
			for(int i= 0; i<nestedList.size(); i++) {
				if(nestedList.get(i).isInteger() || nestedList.get(i).getList().size() >=1) {
					emptylist = false;
				}
			}
			if(!emptylist) {
				nestedIntegerListStack.push(nestedList);
				indexStack.push(0);
			}
		}
	}

	@Override
	public Integer next() {

		int result =-1;

		while(hasNext() && !nestedIntegerListStack.isEmpty() && !indexStack.isEmpty()) {

			List<NestedInteger> topList = nestedIntegerListStack.peek();
			int topIndex = indexStack.peek();

			if(topList.size() <= topIndex) {
				nestedIntegerListStack.pop();
				indexStack.pop();
			}
			else {
				if(topList.get(topIndex).isInteger()) {
					result =  topList.get(topIndex).getInteger();
					indexStack.push(indexStack.pop() +1);
					break;
				}
				else {
					if(topList.get(topIndex).getList().size() >0) {
						nestedIntegerListStack.add(topList.get(topIndex).getList());
						indexStack.push(indexStack.pop() +1);
						indexStack.push(0);
					}
					else {
						indexStack.push(indexStack.pop() +1);
					}
				}
			}
		}

		return result;
	}

	@Override
	public boolean hasNext() {
		while(!nestedIntegerListStack.isEmpty() && !indexStack.isEmpty()) {

			List<NestedInteger> topList = nestedIntegerListStack.peek();
			int topIndex = indexStack.peek();

			if(topList.size() <= topIndex) {
				nestedIntegerListStack.pop();
				indexStack.pop();
			}
			else{
				break;
			}
		}
		return (nestedIntegerListStack.isEmpty() || indexStack.isEmpty())?false:true;
	}
}*/


