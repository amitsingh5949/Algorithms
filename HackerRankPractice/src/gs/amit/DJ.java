package gs.amit;

import java.util.LinkedList;
import java.util.Queue;



public class DJ {

	public static void main(String[] args) {

		int[][] edges = {{1,2},{1,3},{3,4}};

		int[] arr = bfs(5,3,edges,1);
		for(int temp : arr) {
			System.out.print(temp +" ");
		}
	}

	static int[] bfs(int n, int m, int[][] edges, int s) {
		int[] arr = new int[n-1];

		Graph g = new Graph(n);
		for(int i=0; i<m; i++) {
			g.addEdge(edges[i][0]-1, edges[i][1]-1);
		}
        s = s - 1;
        int count = 0;
		for(int i=0; i<n ; i++) {
			if(s!=i) {
				arr[count++] = bfs1(g, s, i);
			}
		}

		return arr;

	}

	public static int bfs1(Graph graph, int currentVertex, int key){

		int result = Integer.MAX_VALUE;
		boolean found = false;

		boolean[] vistedVertex = new boolean[graph.numOfVerticies];

		Queue<Dist> queue = new LinkedList<>();
		queue.add(new Dist(currentVertex,0));

		vistedVertex[currentVertex] = true;

		LinkedList<Integer> currentNeighbhourList = null;

		while(!queue.isEmpty()){

			Dist dist = queue.poll();
			int i = dist.nodeId;
			int d =  dist.d;

			currentNeighbhourList = graph.vertextList[i];
			for(Integer temp : currentNeighbhourList ){
				if(!vistedVertex[temp]){
					vistedVertex[temp] = true;
					queue.add(new Dist(temp,d + 6));
					if(temp == key){
						found = true;
						int distance  = d + 6;
						if(distance < result) {
							result = distance;
						}
					}
				}
			}

		}

		if(found) {
			return result;
		}
		else {
			return -1;
		}
	}



}

class Graph {

	public int numOfVerticies;
	LinkedList<Integer>[] vertextList ;

	public Graph(int numOfVerticies) {
		this.numOfVerticies =  numOfVerticies;
		vertextList = new LinkedList[numOfVerticies];
		for(int i=0; i<numOfVerticies; i++) {
			vertextList[i] = new LinkedList<>();
		}
	}

	public void addEdge(Integer src, Integer dest) {
		vertextList[src].addFirst(dest);
	}
	
	public void printGraph(){
		for(int i=0; i<vertextList.length; i++){
			System.out.print("Vertex " + i +" neighbhour -> " );
			for(Integer temp : vertextList[i]){
				System.out.print(temp + " ");
			}
			System.out.println();
		}
	}

}

class Dist{
	int nodeId, d;

	public Dist(int nodeId, int d) {
		super();
		this.nodeId = nodeId;
		this.d = d;
	}

}



