package problems.algorithms.implementaion;

import java.util.Scanner;

public class MigratoryBirds {

	 static int migratoryBirds(int n, int[] ar) {
	        
	        int[] count = new int[5];
	        int max = count[0];
	        int birdType = 0;
	        for(int i=0; i<ar.length;i++){
	            
	            int type = ar[i];
	            
	            switch(type){
	                    
	                case 1:{
	                   count[0] = count[0] + 1;
	                   break;
	                }
	                case 2:{
	                   count[1] = count[1] + 1;
	                   break;
	                }
	                case 3:{
	                   count[2] = count[2] + 1;
	                   break; 
	                }
	                case 4:{
	                   count[3] = count[3] + 1;
	                   break;
	                }
	                case 5:{
	                   count[4] = count[4] + 1;
	                   break;
	                }    
	            }
	            
	          }
	        
	        for(int i=0; i<count.length;i++){
	            if( count[i] > max){
	                max = count[i];
	                birdType = i;
	            }
	            }
	        
	        return (birdType+1);
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] ar = new int[n];
	        for(int ar_i = 0; ar_i < n; ar_i++){
	            ar[ar_i] = in.nextInt();
	        }
	        int result = migratoryBirds(n, ar);
	        System.out.println(result);
	    }
}
