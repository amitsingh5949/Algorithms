package amazon.sunny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem2 {

	public static void main(String[] args) {
		
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		
		//Integer[][] a =  {{3,6},{2,4},{5,3},{2,7},{1,8},{7,9}};
		
		//Integer[][] a =  {{1,2},{3,4},{1,-1}};
		
		Integer[][] a =  {{1,-3},{1,2},{3,4}};
		
		for(Integer[] a1 : a ) {
			l.add(Arrays.asList(a1));
		}
		
		List<List<Integer>>  x = new Problem2().closestLocations(3, l, 1);
		System.out.println(x);

	}
	
	List<List<Integer>> closestLocations(int totalCrates,List<List<Integer>> allLocations, int truckCapacity){
		
		List<List<Integer>> res = new ArrayList<>();
		Queue<Pos> q = new PriorityQueue<Pos>();

		int i =0;
		
		for(List<Integer> ll : allLocations) {
			q.add(new Pos(ll.get(0),ll.get(1),i++));
		}
		
		
		while(truckCapacity > 0) {
			truckCapacity--;
			int id = q.poll().id;
			res.add(allLocations.get(id));
		}
		
		return res;
	}
	
	class Pos implements Comparable<Pos>{
		
		int x=0;
		int y =0;
		int id  = 0;
		
		public Pos(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}

		@Override
		public int compareTo(Pos o) {
			
			int x1 = this.x;
			int y1 = this.y;
			
			double a1 = (x1*x1) + (y1*y1);
			double d1 = Math.sqrt(a1);
			
			int x2 = o.x;
			int y2 = o.y;
			
			double a2 = (x2*x2) +(y2*y2);
			double d2  = Math.sqrt(a2);
			
			return Double.compare(d1, d2);
			
		}
		
	}

}
