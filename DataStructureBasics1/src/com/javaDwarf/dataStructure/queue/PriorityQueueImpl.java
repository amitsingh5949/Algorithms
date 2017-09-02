package com.javaDwarf.dataStructure.queue;


public class PriorityQueueImpl {
	
	int maxSize;
	int[] priorityQueueArr;
	int top;

	public PriorityQueueImpl(int maxSize){
		this.maxSize = maxSize;
		priorityQueueArr =  new int[maxSize];
		top = -1;
	}
	
	public void push(int element) throws QueueFullException{
		if(!isPriorityQueueFull()){
			if(top == -1){
				 priorityQueueArr[++top] = element;
			}
			else{
				int location = top+1;
				for(int i=0; i<=top; i++){
					if(priorityQueueArr[i] > element){
						location = i;
						break;
					}
				}
				for(int j=top; j>=location; j--){
					priorityQueueArr[j+1] = priorityQueueArr[j];
				}
				priorityQueueArr[location] = element;
				top++;
			}
		}
		else{
			throw new QueueFullException("Priority Queue  is full");
		}
	}
	
	public int pop() throws QueueEmptyException{
		if(!isPriorityQueueEmpty()){
			return priorityQueueArr[top--];
		}
		else{
			throw new QueueEmptyException("Priority Queue  is empty");
		}
	}
	
	public int peek() throws QueueEmptyException{
		if(!isPriorityQueueEmpty()){
			return priorityQueueArr[top];
		}
		else{
			throw new QueueEmptyException("Priority Queue is empty");
		}
	}
	
	public boolean isPriorityQueueEmpty(){
		return (top == -1);
	}
	
	public boolean isPriorityQueueFull(){
		return (top == priorityQueueArr.length-1);
	}

}
