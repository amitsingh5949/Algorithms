package com.javaDwarf.dataStructure.queue;

public class QueueImpl {

	int maxSize;
	int[] queueArr;
	int front;
	int rear;
	int numOfitems;
	
	public QueueImpl(int maxSize){
		this.maxSize = maxSize;
		queueArr = new int[maxSize];
		front = 0;
		rear = -1;
		numOfitems = 0;
	}
	
	public void enque(int element) throws QueueFullException{
		if(!isQueueFull()){
			if(rear == queueArr.length-1){
				rear = -1;
			}
			queueArr[++rear] = element;
			numOfitems++;
		}
		else{
			throw new QueueFullException("Queue is full");
		}
	}
	
	public int deque() throws QueueEmptyException{
		if(!isQueueEmpty()){
			int frontElement = queueArr[front++];
			if(front == queueArr.length){
				front = 0;
			}
			numOfitems--;
			return frontElement ;
		}
		else{
			throw new QueueEmptyException("Queue is empty");
		}
	}
	
	public int peekFront() throws QueueEmptyException{
		if(!isQueueEmpty()){
			return queueArr[front] ;
		}
		else{
			throw new QueueEmptyException("Queue is empty");
		}
	}
	
	public int peekRear() throws QueueEmptyException{
		if(!isQueueEmpty()){
			return queueArr[rear] ;
		}
		else{
			throw new QueueEmptyException("Queue is empty");
		}
	}


	public boolean isQueueFull(){
		return (numOfitems == maxSize);
	}
	
	public boolean isQueueEmpty(){
		return (numOfitems == 0);
	}
	
	public int size(){
		return numOfitems;
	}
	
}
/** 
 * Exercise : try implementing Queue without numOfItems(help can be taken from lafore)
 */
