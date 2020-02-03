package zappos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// > > < < > > * > <

// >>>*>*<*>> 

public class Problem1 {

	
	public static void main(String[] args) {
		
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
        	
        	String inp =  bufferedReader.readLine().trim();
            System.out.println(getYear(inp.toCharArray()));
           

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

	}
	
	public static int getYear(char[] symbols) {
		
		int res =  0 ;
		
		int[] val = new int[symbols.length];
		
		for(int i=0; i<val.length; i++) {

			if(symbols[i]== '>') {
				val[i] = 1;
 			}
			else if(symbols[i]=='<') {
				val[i] = -1;
			}
			else {
				int j =i-2 ;
				while(j>=0  && symbols[j]=='*') {
					j -= 2;
				}
				val[j] *= 2;
			}
		}
		
		for(int i : val) {
			res += i;
		}
		
		return 2017 + res;
		
	}
	
	
	
	
	
	

}
