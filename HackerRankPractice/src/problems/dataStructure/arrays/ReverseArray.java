package problems.dataStructure.arrays;

import java.util.Scanner;

public class ReverseArray {

	


	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        boolean flag = true;
        for(int i = n-1; i >= 0; i--){
            if(flag){
            System.out.print(arr[i]);
                flag = false;
            }
            else{
                System.out.print(" " + arr[i]);
            }
        }
    }



}
