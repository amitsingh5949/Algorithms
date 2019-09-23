package twitter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuyingShowTickets {

	public static void main(String[] args) {

	}
	
	public static long waitingTime(List<Integer> tickets, int p) {
		
		
		/*Queue<Person> q = new LinkedList<>();
		for(int i =0; i<tickets.size(); i++ ) {
			q.offer(new Person(i, tickets.get(i)));
		}
		
		long waitTime = 0l;
		
		while(!(q.peek().id == p && q.peek().numofTickets==1)) {
			Person person = q.poll();
			if(person.numofTickets ==1) {
				waitTime++;
				continue;
			}
			person.numofTickets -= 1;
			q.offer(person);
			waitTime++;
		}
		
		return ++waitTime;*/
		
		int count = tickets.get(p);
		
		long waitTime = 0l;
		
		for(int i=0; i<tickets.size(); i++) {
			
			if(i <= p ) {
				int currCount = tickets.get(i);
				if(currCount < count) {
					waitTime += currCount;
				}
				else {
					waitTime += count;
				}
			}
			else {
				int currCount = tickets.get(i);
				if(currCount < count) {
					waitTime += currCount;
				}
				else {
					waitTime += count-1;
				}
			}
			
		}
		
		return waitTime;
		
	}

}

class Person{
	public int id;
	public int numofTickets;
	public Person(int id, int numofTickets) {
		this.id = id;
		this.numofTickets = numofTickets;
	}
	
}
