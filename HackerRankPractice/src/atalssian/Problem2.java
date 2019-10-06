package atalssian;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {

	public static void main(String[] args) {

	}
	
	/*
	 
const int N = 10000; 
vector<int> graph[N]; 
  
// Initially all nodes 
// marked as unvisited 
bool visited[N]; 
  
// DFS function that visits all 
// connected nodes from a given node 
void dfs(int node, int a[], int mini) 
{ 
    // Stores the minimum 
    mini = min(mini, a[node]); 
  
    // Marks node as visited 
    visited[node] = true; 
  
    // Traversed in all the connected nodes 
    for (int i : graph[node]) { 
        if (!visited[i]) 
            dfs(i, a, mini); 
    } 
} 
  
// Function to add the edges 
void addedge(int u, int v) 
{ 
    graph[u - 1].push_back(v - 1); 
    graph[v - 1].push_back(u - 1); 
} 
  
// Function that returns the sum of all minimums 
// of connected componenets of graph 
int minimumSumConnectedComponents(int a[], int n) 
{ 
    // Initially sum is 0 
    int sum = 0; 
  
    // Traverse for all nodes 
    for (int i = 0; i < n; i++) { 
        if (!visited[i]) { 
            int mini = a[i]; 
            dfs(i, a, mini); 
            sum += mini; 
        } 
    } 
      
    // Returns the answer 
    return sum; 
} 
	 
	 */
	
	static LinkedList<Integer>[] vertextList;
	static int numOfVertecies;
	
	public static void addEdge(int src, int neighbhour){
		vertextList[src].addFirst(neighbhour);
	}
	
	public static void dfs(int currentVertex, int key){
		boolean[] vistedVertex = new boolean[numOfVertecies];
		dfs(currentVertex,0,vistedVertex);
	}
	
	public static int  dfs(int currentVertex, int key, boolean[] vistedVertex){
		vistedVertex[currentVertex] = true;
		LinkedList<Integer> currentNeighbhourList = vertextList[currentVertex];
		for(Integer temp : currentNeighbhourList ){
			if(!vistedVertex[temp])
				key = dfs(temp,key+temp,vistedVertex);
		}
		
		return key;
	}
	
	public static int connectedSum(int n, List<String> edges) {
		
		int sum = 0; 
		
		vertextList = new LinkedList[n];
		numOfVertecies =n;
		for(int i=0; i<n; i++){
			vertextList[i] = new LinkedList<>();
		}
		
		for(String temp : edges) {
			String[] arr = temp.split(" ");
			addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		}
		
		
		return sum;
		
	}

}
