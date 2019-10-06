package purestorage;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

	public static void main(String[] args) {
		System.out.println(compute_number_score(0000));
	}

	
	
    static int compute_number_score(int number) {
        if(number==0){
            return 4;
        }
        return getDigitWiseScore(number)  + countConsecutivefives(number) +get(number);

    }
    public static int getDigitWiseScore(int num){
        int score = 0;
        if(num%3==0) score+=2;
        while(num>0){
            int d = num%10;
            if(d==7) score+=1;
            if(d%2==0) score+=4;
            num = num/10;
        }
        return score;
    }
    public static int countConsecutiveOnes(int num){
        int score =0;
        int currentOnes = 0;
        while(num > 0 ){
            int d = num%10;
            num = num/10;
            if(d!=1 && currentOnes == 1 ){
            	currentOnes = 0;
            }
            if(d!=1 && currentOnes > 1 ){
                score+=5;
                score += (currentOnes-2)*5;
                currentOnes = 0;
            }
            if(d==1){
                currentOnes++;
            }
        }
        if(currentOnes> 1){
            score+=5;
            score += (currentOnes-2)*5;
        }
        return score;
    }
    
    public static int countConsecutivefives(int num){
        int score =0;
        int currentOnes = 0;
        while(num > 0 ){
            int d = num%10;
            num = num/10;
            if(d!=5 && currentOnes == 1 ){
            	currentOnes = 0;
            }
            if(d!=5 && currentOnes > 1 ){
                score+=3;
                score += (currentOnes-2)*3;
                currentOnes = 0;
            }
            if(d==5){
                currentOnes++;
            }
        }
        if(currentOnes> 1){
            score+=3;
            score += (currentOnes-2)*3;
        }
        return score;
    }
    

    public static int get(int num) {
        int x=0, count=1;
        List<Integer> store = new ArrayList<>();
        String s = Integer.toString(num);
        while(x<s.length()-1) {
            if (s.charAt(x) == s.charAt(x+1)+1){
                count ++;
                x++;
            }
            else {
                x++;
                store.add(count);
                count = 1;
            }
        }
        store.add(count);
        int score = 0;
        for(Integer i: store){
            score += i*i;
        }
        return score;

    }


}



