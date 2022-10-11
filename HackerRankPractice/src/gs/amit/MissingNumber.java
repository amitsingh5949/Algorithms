package gs.amit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MissingNumber {

	public static void main(String[] args) {
		//int [] arr = missingNumbers(new int[] {}, new int[] {7,2,5,4,6,3,5,3});
		
		int [] arr = missingNumbers(new int[] {6,7}, new int[] {});
		
		for(int x : arr) {
			System.out.print(x + " ");
		}
	}


	public static int[] missingNumbers(int[] arr, int[] brr) {
		int [] miss = new int[brr.length-arr.length];
		
		Set<Integer> set = new HashSet<Integer>();
		
		if(brr==null || brr.length==0) return miss;
		
		if(arr==null || arr.length==0) return brr;
		

		Arrays.sort(brr);

		Arrays.sort(arr);

		int count = 0;
		int j =0 ;
		for(int i= 0; i<brr.length; i++) {
			if(brr[i] != arr[j]) {
				set.add(brr[i]);
				continue;
			}
			j++;

		}
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			miss[count++] = itr.next();
		}
		
		
        Arrays.sort(miss);
		return miss;

	}
}
