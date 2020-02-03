package amazon.practice;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

	public static void main(String[] args) {
		
		int[] arr = {1,0,0,0,0,1,0,0};
		
		System.out.println(new Problem1().cellCompete(arr, 1));

	}
	
	public List<Integer> cellCompete(int[] states, int days){
		
		int[] oldStates = new int[states.length+2];
		
		for(int i=0; i<states.length;i++) {
			oldStates[i+1] = states[i];
		}
		
		for(int i=0; i<days;i++) {
			oldStates = update(oldStates);
		}
		
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i=1; i<oldStates.length-1; i++) {
			res.add(oldStates[i]);
		}
		
		return res;
    }
	
	public int[] update(int[] oldStates) {
		
		int[] newState = new int[oldStates.length];
		
		for(int i=1; i<oldStates.length-1; i++) {
			
			if( (oldStates[i-1] == 1 && oldStates[i+1] == 1) || (oldStates[i-1] == 0 && oldStates[i+1] == 0)) {
				newState[i] = 1;
			}
			else {
				newState[i] = 0;
			}
		}
		
		return newState;
		
	}

}
