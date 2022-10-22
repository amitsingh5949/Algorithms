package vmware;

import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
           
            int num = s.nextInt();
            for(int j = 1; j <= num; j++){
                if(j%3!=0 && j%5!=0 ){
                 System.out.println(j);   
                }
                else if(j%3==0 && j%5!=0 ){
                 System.out.println("Fizz");   
                }
                else if(j%3!=0 && j%5==0 ){
                 System.out.println("Buzz");   
                }
                else if(j%3==0 && j%5==0 ){
                 System.out.println("FizzBuzz");   
                }
            
            }
        }
        s.close();
    }
}
