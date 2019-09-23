package demo;

import java.util.HashMap;
import java.util.Map;

public class VM_Ware_HackerRank_1 {
	public static int ret(int [][] arr) {
	Map<Integer,Integer> count = new HashMap<Integer,Integer>();
	int c1=0,res=0;
	for(int i=0;i<arr.length;i++) {
		for(int j=0;j<arr.length;j++) {
			if(arr[i][j]==1) {
				c1++;
				res=Math.max(c1,res );
				
			}
			else {
				c1=0;
			}
			//c1++;
		}
		count.put(i, res);
		c1=0;
		res=0;
	}
	for(int i :count.values()) {
		
	}
	return c1;
	}
	public static void main(String []args) {
		int arr[][]= {{1,1,1,1},{1,1,0,0},{1,0,0,1},{0,0,1,1}};
		System.out.print(ret(arr));
	}
}
