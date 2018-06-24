package problems.dataStructure.arrays;

import java.util.LinkedList;
import java.util.Scanner;

public class SequenceListXOR {

	


	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        LinkedList<Integer>[] seqList = new LinkedList[N];
        int numQuery = in.nextInt();
        int lastAnswer = 0;
        for(int i=0; i<=numQuery;i++){
        	int querId = in.nextInt();
        	int x = in.nextInt();
        	int y = in.nextInt();
        	
        	int index = calculateQueryOneResult(x,lastAnswer,N);
        	if(querId == 1){
        		if(seqList[index] == null){
        			LinkedList<Integer> seq = new LinkedList<Integer>();
        			seq.addLast(Integer.valueOf(y));
        			seqList[index] = seq;
        		}
        		else{
        			seqList[index].addLast(Integer.valueOf(y));
        		}
        	}
        	else if(querId == 2){
        		LinkedList<Integer> seq = seqList[index];
        		if(seq != null){
        			lastAnswer = seq.get(y % (seq.size()));
        			System.out.println(lastAnswer);
        		}
        	}
        }
        in.close();
       
    }
	
	public static int calculateQueryOneResult(int x, int lastAnswer, int N){
		return ((x^lastAnswer)%N);
	}
	



}
