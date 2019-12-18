package amazon.aakash;

import java.util.ArrayList;

public class Problem1 {

	public static void main(String[] args) {
		
		Integer[] arr = {20,70,90,30,60,110};
		
		//Integer[] arr = {100,180,40,120,10};
		
		
		ArrayList<Integer> l  = new ArrayList<Integer>();
		for(int i : arr) {
			l.add(i);
		}
		System.out.println(new Problem1().movieDuration(110, l));
	}

	public ArrayList<Integer> movieDuration(int flightDuration, ArrayList<Integer> movieDuration){
		
		int movie1 = 0;
		int movie2  =0 ;
		
		ArrayList<Integer> l = new ArrayList<>();
		
		for(int i=0; i<movieDuration.size()-1; i++) {
			
			for(int j=i+1; j<movieDuration.size(); j++) {
				
				int temp = movieDuration.get(i) + movieDuration.get(j);
				
				if( temp<= flightDuration-30 && (temp > movie1+movie2  || ( temp == movie1+movie2 && 
						( (movieDuration.get(i) >= movie1 && movieDuration.get(i) >= movie2) ) || (movieDuration.get(j) >= movie1 && movieDuration.get(j) >= movie2))) ){
					l.clear();
					l.add(i);
					l.add(j);
					movie1 = movieDuration.get(i);
					movie2 = movieDuration.get(i);
				}
				
			}
		}
		
		return l;
	}
	
	
	/*
	//private static int[] twoSumCloset(int[] movies, int flightDuration) {
	public ArrayList<Integer> movieDuration(int flightDuration, ArrayList<Integer> movieDuration){
        Collections.sort(movieDuration);
        int duration = flightDuration - 30;
        int first = 0;
        int last = movieDuration.size() - 1;

        int[] result = new int[2];
        while (first < last){
            int d1 = movieDuration.get(first);
            int d2 = movieDuration.get(last);
            int sum  = d1 + d2;
            if(sum < duration){
                first++;
            }
            else{
                last--;
            }
            updateResult(first, last , result, duration);
        }
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        
        for(int x : result) {
        	
        	for(int i=0; i<movieDuration.size(); i++) {
        		if(movieDuration.get(i) == x) {
        			l.add(i);
        			break;
        		}
        	}
        
        }
        
        return l;
    }

    private static void updateResult(int d1, int d2, int[] result , int duration){
        int sum = d1 + d2;
        if(sum > result[0] + result[1] && sum <= duration){
            result[0] = d1;
            result[1] = d2;
        }
    }
    */
}
