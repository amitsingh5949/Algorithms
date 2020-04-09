package fundingcircles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size =  in.nextInt(); 
		long[] arr = new long[size];
		
		Map<Long, Integer> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			long temp = in.nextLong();
			int count = map.getOrDefault(temp, 0);
			map.put(temp, count);
		}
		
		long result = 0;
		
		for(Map.Entry<Long, Integer> e : map.entrySet()) {
			if( e.getValue()%2 == 0) {
				result += e.getKey();
			}
		}
		System.out.println(result);
		in.close();
	}
	
	
	
	
	

}
