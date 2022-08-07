package com.javadwarf.heap.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _1057_CampusBikes {

	public static void main(String[] args) {

		int[][] arr1 = {{0,0},{1,1},{2,0}};
		int[][] arr2 ={{1,0},{2,2},{2,1}};
		System.out.println(new _1057_CampusBikes().assignBikes12(arr1, arr2));
	}

	// using counting sort as max coordinate of any bike or worker is less than 1000, 
	//then we can have max distance b/w any worker and bike as 2000
	// Store all bike and worker pair in an array of size 2001 where index would the distance
	// To handle collision with same distance, at each bucket we will keep 
	// a list and add all bike-worker pairs to it

	public int[] assignBikes(int[][] workers, int[][] bikes) {

		List<int[]>[] distances = new ArrayList[2000];
		
		for(int i=0; i<workers.length; i++) {
			for(int j=0; j<bikes.length; j++) {
				int d = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
				if(distances[d] == null) {
					distances[d] = new ArrayList<int[]>();
				}
				distances[d].add(new int[] {i,j});
			}
		}

		int[] res = new int[workers.length];
		Set<Integer> usedBikes = new HashSet<>();
		Set<Integer> usedWorker = new HashSet<>();
		
		int assigned = 0;
		
		for(int i=0; i<2000 && assigned<workers.length; i++) {
			if(distances[i]!= null) {
				
				int worker = Integer.MAX_VALUE;
				int bike = Integer.MAX_VALUE;
				
				for(int[] arr : distances[i]) {
					if(!usedWorker.contains(arr[0]) && !usedBikes.contains(arr[1])) {
						if(worker > arr[0] || (worker == arr[0] && bike > arr[1] )) {
							worker = arr[0];
							bike = arr[1];
							res[worker] = bike;
							usedBikes.add(bike);
							usedWorker.add(worker);
							worker = Integer.MAX_VALUE;
							bike = Integer.MAX_VALUE;
							assigned++;
						}
					}
				}
				
			}
		}
		return res;
	}
	
	// wrong logic to handle collision
	public int[] assignBikes2(int[][] workers, int[][] bikes) {

		int[][] distances = new int[2000][2];
		for(int[] arr : distances) { 
			Arrays.fill(arr, -1);
		}

		for(int i=0; i<workers.length; i++) {
			for(int j=0; j<bikes.length; j++) {
				int d = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
				if(distances[d][0] == -1 || distances[d][0] > i || (distances[d][0] == i && distances[d][1] > j) ){
					distances[d] = new int[] {i,j};
					System.out.println(d+" "+i+" "+j);
				}
			}
		}

		int[] res = new int[workers.length];
		Set<Integer> usedBikes = new HashSet<>();
		Set<Integer> usedWorker = new HashSet<>();

		for(int i=0; i<2000; i++) {
			if(distances[i][0] != -1 && !usedWorker.contains(distances[i][0]) && !usedBikes.contains(distances[i][1]) ) {
				res[distances[i][0]] = distances[i][1];
				usedWorker.add(distances[i][0]);
				usedBikes.add(distances[i][1]);
			}
		}
		return res;
	}


	// with priority Queue O(nmlog(nm)

	public int[] assignBikes1(int[][] workers, int[][] bikes) {
		int[] res = new int[workers.length];
		Queue<Chettinad> q = new PriorityQueue<>();
		Set<Integer> usedBikes = new HashSet<>();
		Set<Integer> usedWorker = new HashSet<>();
		for(int i=0; i<workers.length; i++) {
			for(int j=0; j<bikes.length; j++) {
				q.add(new Chettinad(i,workers[i][0], workers[i][1], j, bikes[j][0], bikes[j][1]));
			}
		}

		while(!q.isEmpty()) {
			Chettinad c = q.poll();
			if(!usedBikes.contains(c.bikeIndex) && !usedWorker.contains(c.workerIndex)) {
				res[c.workerIndex] = c.bikeIndex;
				usedBikes.add(c.bikeIndex);
				usedWorker.add(c.workerIndex);
			}
		}
		return res;
	}
	
	
	public int[] assignBikes12(int[][] workers, int[][] bikes) {
        
PriorityQueue<int[]>[] workerBikePreference = new PriorityQueue[workers.length];
        
        for(int i=0; i<workers.length; i++){
            
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
            	 int worker1x = workers[a[0]][0];
                 int worker1y = workers[a[0]][1];
                 int bike1x = bikes[a[1]][0];
                 int bike1y = bikes[a[1] ][1];

                 int d1 = Math.abs(worker1x-bike1x) + Math.abs(worker1y-bike1y);

                 int worker2x = workers[b[0]][0];
                 int worker2y = workers[b[0]][1];
                 int bike2x = bikes[b[1]][0];
                 int bike2y = bikes[b[1]][1];

                 int d2 = Math.abs(worker2x-bike2x) + Math.abs(worker2y-bike2y);

                 if(d1 == d2){
                     if(a[0] == b[0]){
                         return a[0]-b[0];
                     }
                     return a[1]-b[1];
                 }
                 return d1-d2;
            });
            
            workerBikePreference[i] = pq;
            
            for(int j=0; j<bikes.length; j++){
                pq.add(new int[]{i,j});
            }
        }
        
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] avialbleBikes = new boolean[bikes.length];
        Arrays.fill(avialbleBikes,true);
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
       	 int worker1x = workers[a[0]][0];
            int worker1y = workers[a[0]][1];
            int bike1x = bikes[a[1]][0];
            int bike1y = bikes[a[1] ][1];

            int d1 = Math.abs(worker1x-bike1x) + Math.abs(worker1y-bike1y);

            int worker2x = workers[b[0]][0];
            int worker2y = workers[b[0]][1];
            int bike2x = bikes[b[1]][0];
            int bike2y = bikes[b[1]][1];

            int d2 = Math.abs(worker2x-bike2x) + Math.abs(worker2y-bike2y);

            if(d1 == d2){
                if(a[0] == b[0]){
                    return a[0]-b[0];
                }
                return a[1]-b[1];
            }
            return d1-d2;
       });
        
        for(int i=0; i<workers.length; i++){
             pq.add(workerBikePreference[i].poll());
        }
        
        int count = 0;               
        
        while(count < workers.length && !pq.isEmpty()){
            
            int[] curr = pq.poll();
            int worker = curr[0];
            int bike = curr[1];
            
            if(avialbleBikes[bike]) {
                avialbleBikes[bike] = false;
                res[worker] = bike;
                count++;
            }
            else{
                pq.add(workerBikePreference[worker].poll());
            }
        }
        
        return res;
	        
	    }

} 
class Chettinad implements Comparable<Chettinad>{
	int workerIndex;
	int workerX;
	int workerY;
	int bikeIndex;
	int bikeX;
	int bikeY;

	public Chettinad(int workerIndex, int workerX, int workerY, int bikeIndex, int bikeX, int bikeY) {
		super();
		this.workerIndex = workerIndex;
		this.workerX = workerX;
		this.workerY = workerY;
		this.bikeIndex = bikeIndex;
		this.bikeX = bikeX;
		this.bikeY = bikeY;
	}

	@Override
	public int compareTo(Chettinad c) {

		int d1 = Math.abs(this.workerX -this.bikeX) + Math.abs(this.workerY -this.bikeY);
		int d2 = Math.abs(c.workerX -c.bikeX) + Math.abs(c.workerY -c.bikeY);
		int res = Integer.compare(d1, d2);
		if(res == 0) {
			int x = Integer.compare(this.workerIndex, c.workerIndex);
			if(x ==0) {
				return Integer.compare(this.bikeIndex, c.bikeIndex);
			}

			return x;
		}
		return res;
	}
	
	
	//Now correct pq
	
	


}
