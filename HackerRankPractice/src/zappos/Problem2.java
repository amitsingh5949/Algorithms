package zappos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem2 {



	public static void main(String[] args) throws Exception{

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {

			String[] arr = bufferedReader.readLine().trim().split(" ");

			int B = Integer.parseInt(arr[0]);
			int W = Integer.parseInt(arr[1]);
			int N = Integer.parseInt(arr[2]);

			int[] sizes = new int[N];

			for(int i= 0; i<N; i++) {
				sizes[i] = Integer.parseInt(bufferedReader.readLine().trim());
			}

			if(W > B) {
				System.out.println("Not enough balance");
			}

			if(isChangePossible(sizes, B-W) == -1) {
				System.out.println("Cannot put into packets");
			}

			getRatio(B, W, N, sizes);


		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void getRatio(int B, int W, int N, int[] sizes){
		
		int amount = B-W;

		Map<Integer, Integer> map = minimumCoinBottomUp(amount, sizes);
		
		String res = "";
		List<Integer> keys =new ArrayList<Integer>( map.keySet());
		Collections.sort(keys);
		for(int key : keys) {
			res += key+":"+map.get(key)+" ";
		}
		res += amount;
		System.out.println(res);
	}
	
	
	public static Map<Integer, Integer>  minimumCoinBottomUp(int total, int coins[]){
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= total; i++){
                if(i >= coins[j]){
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        Map<Integer, Integer>  map =  printCoinCombination(R, coins);
        return map;
    }

    private static Map<Integer, Integer>  printCoinCombination(int R[], int coins[]) {
       
    	 Map<Integer, Integer> map = new TreeMap<>();
    	
    	if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return map;
        }
        
       
        int start = R.length - 1;
        while ( start != 0 ) {
            int j = R[start];
            
        	
            System.out.print(coins[j] + " ");
            int count1 = map.getOrDefault(coins[j], 0);
            map.put(coins[j], count1+1);
            start = start - coins[j];
        }
        
        return map;
    }

	public static  int isChangePossible(int[] sizes, int amount) {

		if(amount < 1) return 0;

		int[][] matrix = new int[sizes.length+1][amount+1];

		for(int i=0; i<matrix.length; i++) {

			for(int j=0; j<matrix[i].length; j++) {

				if(i==0 || j==0) {
					matrix[i][j] = amount+1;
				}
				else if(sizes[i-1] == j ) {
					matrix[i][j] = 1;
				}
				else if(sizes[i-1] > j) {
					matrix[i][j] = matrix[i-1][j];
				}
				else {
					matrix[i][j] = Integer.min(matrix[i-1][j], 1 + matrix[i][j-sizes[i-1]]);
				}
			}
		}
		return matrix[sizes.length][amount] == amount+1 ? -1 : matrix[sizes.length][amount];
	}

}
