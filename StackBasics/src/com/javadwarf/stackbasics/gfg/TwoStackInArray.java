package com.javadwarf.stackbasics.gfg;

public class TwoStackInArray {

	public static void main(String[] args) {

	}

}


class GfG
{
    // sq is the object of class TwoStack
    /* The method push to push element into the stack 2 */
    void push1(int x, TwoStack sq)
    {
    	if(sq.top2-sq.top1>1) {
    		sq.top1 = sq.top1+1;
    		sq.arr[sq.top1] = x;
    	}
    }
    /* The method push to push element into the stack 2*/
    void push2(int x, TwoStack sq)
    {
    	if(sq.top2-sq.top1>1) {
    		sq.top2 = sq.top2-1;
    		sq.arr[sq.top2] = x;
    	}
    }
    /* The method pop to pop element from the stack 1 */
    int pop1(TwoStack sq)
    {
    	int temp = -1;
    	if(sq.top1>=0) {
    		temp=sq.arr[sq.top1] ;
    		sq.arr[sq.top1] = 0;
    		sq.top1 = sq.top1-1;
    	}
    	return temp;
    }
    /* The method pop to pop element from the stack 2 */
    int pop2(TwoStack sq)
    {
    	int temp = -1;
    	if(sq.top2<sq.size) {
    		temp=sq.arr[sq.top2] ;
    		sq.arr[sq.top2] = 0;
    		sq.top2 = sq.top2+1;
    	}
    	return temp;
    }
}

class TwoStack
{
	int size;
	int top1,top2;
	int arr[] = new int[100];
	TwoStack()
	{
		size = 100;
		top1 = -1;
		top2 = size;
	}
}
