package visa;

import java.util.List;

public class problem1 {

	public static void main(String[] args) {

	}
	
	public static int restock (List<Integer> itemCount, int target) {
		
		
		int currCount = 0;
		
		for(int i=0; i<itemCount.size(); i++){
			currCount += itemCount.get(i);
			if(currCount >= target) {
				return (currCount - target);
			}
		}
		return target - currCount;
		
	}

}
