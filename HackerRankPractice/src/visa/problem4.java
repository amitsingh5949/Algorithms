package visa;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class problem4 {
	
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1000000000);
		System.out.println(new problem4().segment(1, arr));
	}

	public static int segment(int x, List<Integer> arr) {
		
		int[] result = new int[arr.size() - (x-1)];
		Queue<Element> pq = new PriorityQueue<Element>();

		for(int i = 0 ; i <x; i++) {
			pq.add(new Element(i, arr.get(i)));
		}
		
		if(x == arr.size()) {
			return pq.peek().value;
		}

		for(int i=x; i<arr.size(); i++) {
			Element e = pq.peek();
			result[i-x] = e.value;
			while( !pq.isEmpty() && (i-e.index >= x || e.value > arr.get(i) )) {
				pq.poll();
				e = pq.peek();
			}
			pq.add(new Element(i, arr.get(i)));
		}
		
		
		int max = Integer.MIN_VALUE;
		for(int i : result) {
			max = Integer.max(i, max);
		}
		return max;
		
	}

}

class Element implements Comparable<Element>{
	int index, value = 0;
	public Element(int index, int value) {
		this.index = index;
		this.value = value;
	}
	@Override
	public String toString() {
		return "index=" + index + ", value=" + value;
	}

	@Override
	public int compareTo(Element e) {
		return Integer.compare(this.value, e.value);

	}
}
