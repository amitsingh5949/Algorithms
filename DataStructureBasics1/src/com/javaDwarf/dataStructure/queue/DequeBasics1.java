package com.javaDwarf.dataStructure.queue;


public class DequeBasics1 {

	public static void main(String[] args) {
		DequeueImpl deque = new DequeueImpl(5);
		PriorityQueueImpl pque = new PriorityQueueImpl(10);
		
		try{
			deque.insertRear(67);
			deque.printDeque();
			deque.insertFront(56);
			deque.printDeque();
			deque.deleteRear();
			deque.printDeque();
			deque.deleteRear();
			deque.printDeque();
			/*deque.insertFront(1);
			deque.printDeque();
			deque.insertRear(11);
			deque.printDeque();
			deque.deleteRear();
			deque.printDeque();
			deque.deleteFront();
			deque.printDeque();
			deque.deleteFront();
			deque.printDeque();
			deque.deleteRear();
			deque.printDeque();
			*/
			
			
			for(int i= 0; i<=10;i++){
				try {
					pque.push((int) (Math.random()*100));
				} catch (QueueFullException e) {
					System.out.println(e.getMessage());
				}
			}

			try {
				System.out.println(pque.peek());
			} catch (QueueEmptyException e) {
				System.out.println(e.getMessage());
			}

			while(!pque.isPriorityQueueEmpty()){
				try {
					System.out.println(pque.pop());
				} catch (QueueEmptyException e) {
					System.out.println(e.getMessage());
				}
			}
			
		}
		catch(QueueFullException e){
			System.out.println(e.getLocalizedMessage());
		} catch (QueueEmptyException e) {
			e.printStackTrace();
		}

	}

}
