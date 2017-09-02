package com.javaDwarf.dataStructure.queue;

public class DequeueImpl {

	private int maxSize;
	private int deQueueArr[];
	private int front;
	private int rear;
	private int numOfItems;

	public DequeueImpl(int maxSize) {
		this.maxSize = maxSize;
		deQueueArr =  new int[maxSize];
		front = 0;
		rear = -1;
		numOfItems = 0;
	}

	public void insertFront(int element) throws QueueFullException{
		if(!isDequeueFull()){
			if(front == 0 && rear == -1){
				rear = 0;
			}
			else if(front == 0 && rear != -1){
				front = maxSize-1;
			}
			else{
				front--;
			}
			deQueueArr[front] = element;
			numOfItems++;
		}
		else{
			throw new QueueFullException("Deque is full");
		}
	}

	public int deleteFront() throws QueueEmptyException{

		if(!isDequeueEmpty()){
			int frontElement = deQueueArr[front++];
			if(front == maxSize && rear != maxSize-1){
				front = 0;
			}
			else if(front == maxSize && rear == maxSize-1){
				rear=-1;
				front=0;
			}
			else if(front == 1 && rear == 0){
				rear=-1;
				front=0;
			}
			numOfItems--;
			return frontElement;
		}
		else{
			throw new QueueEmptyException("Deque is empty");
		}
	}

	public void insertRear(int element) throws QueueFullException{
		if(!isDequeueFull()){
			if(rear == maxSize-1){
				rear=-1;
			}
			deQueueArr[++rear] = element;
			numOfItems++;
		}
		else{
			throw new QueueFullException("Deque is full");
		}
	}

	public int deleteRear() throws QueueEmptyException{
		if(!isDequeueEmpty()){
			int rearElement = deQueueArr[rear--];
			if(rear == -1 && front != 0){
				rear = maxSize-1;
			}
			else if(rear == maxSize-2 && front == maxSize-1){
				rear=-1;
				front=0;
			}
			numOfItems--;
			return rearElement;
		}
		else{
			throw new QueueEmptyException("Deque is empty");
		}
	}

	public int peekFront() throws QueueEmptyException{
		if(!isDequeueEmpty()){
			return deQueueArr[front] ;
		}
		else{
			throw new QueueEmptyException("Queue is empty");
		}
	}

	public int peekRear() throws QueueEmptyException{
		if(!isDequeueFull()){
			return deQueueArr[rear] ;
		}
		else{
			throw new QueueEmptyException("Queue is empty");
		}
	}

	public boolean isDequeueEmpty(){
		return (numOfItems == 0);
	}

	public boolean isDequeueFull(){
		return (numOfItems == maxSize);
	}

	public int size(){
		return numOfItems;
	}

	public void printDeque(){ 
		System.out.print("Deque is :[ ");
		for(int temp : deQueueArr){
			System.out.print(temp+",");
		}
		System.out.print(" ] with front : " + front + " and rear : " + rear + "\n");
	}
}
