package symphony;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

import symphony.Problem1.Component;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

interface TimeProvider {
	long getMillis();
}

public class CachingDataStructure {

	private int maxSize;
	private TimeProvider timeProvider;
	Map<String, Val> map = null;
	Queue<Val> pq = null;

	CachingDataStructure(TimeProvider timeProvider, int maxSize) {
		this.timeProvider = timeProvider;
		this.maxSize = maxSize;
		map = new HashMap<>();
		pq = new PriorityQueue<>((a,b) -> Long.compare(a.timeToLeaveInMilliseconds, b.timeToLeaveInMilliseconds)
				);

	}

	public void put(String key, String value, long timeToLeaveInMilliseconds) {

		//throw new NotImplementedException();

		if(key == null || value == null ) {
			throw new IllegalArgumentException();
		}

		long currTime = timeProvider.getMillis();

		while(!pq.isEmpty() && pq.peek().timeToLeaveInMilliseconds < currTime) {
			Val e = pq.poll();
			map.remove(e.key);
		}

		if(pq.isEmpty()) {
			Val v = new Val(key, value, currTime + timeToLeaveInMilliseconds);
			map.put(key, v);
			pq.add(v);
		}
		else if(currTime + timeToLeaveInMilliseconds > pq.peek().timeToLeaveInMilliseconds && size() < maxSize) { 
			Val v = new Val(key, value, currTime + timeToLeaveInMilliseconds);
			map.put(key, v);
			if(pq.contains(v)) {
				pq.remove(v);
			}
			pq.add(v);
		}
	}

	public Optional<String> get(String key) {

		if(key != null && map.containsKey(key)) {
			return Optional.ofNullable(map.get(key).value);
		}

		throw new IllegalArgumentException();
	}

	public int size() {
		return map.size();
		//throw new NotImplementedException();
		//throw new IllegalArgumentException();
	}

}

class Val{
	String key;
	String value;
	long timeToLeaveInMilliseconds;

	public Val(String key, String value, long timeToLeaveInMilliseconds) {
		super();
		this.key = key;
		this.value = value;
		this.timeToLeaveInMilliseconds = timeToLeaveInMilliseconds;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Val other = (Val) obj;
		if (!this.key.equals(other.key))
			return false;
		return true;
	}




}
