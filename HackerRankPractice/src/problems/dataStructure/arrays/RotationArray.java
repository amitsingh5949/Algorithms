package problems.dataStructure.arrays;

import java.util.Scanner;

public class RotationArray {




	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		int numRotation= in.nextInt();
		for(int arr_i=0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}

		/*for(int i=0; i<numRotation;i++){
			int temp = 0;
			for(int j=0; j<n;j++){
				if(j==0){
					temp = arr[j];
				}
				if(j!=n-1){
					arr[j]=arr[j+1];
				}
				else{
					arr[j]=temp;	
				}
			}
			boolean flag = true;
		for(int i = 0; i < n; i++){
			if(flag){
				System.out.print(arr[i]);
				flag = false;
			}
			else{
				System.out.print(" " + arr[i]);
			}
		}

		}*/
		int arr1[] = new int[n];
		int index = 0;
		for(int i=numRotation; i<n; i++){
			arr1[index++]=arr[i];
		}
		for(int i=0; i<numRotation; i++){
			arr1[index++]=arr[i];
		}

		boolean flag = true;
		for(int i = 0; i < n; i++){
			if(flag){
				System.out.print(arr1[i]);
				flag = false;
			}
			else{
				System.out.print(" " + arr1[i]);
			}
		}
	}



}
