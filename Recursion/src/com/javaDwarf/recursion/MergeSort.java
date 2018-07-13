package com.javaDwarf.recursion;

public class MergeSort {

	public static void main(String[] args) {
		int [] in = {6,4,3,1,2,9,5,10,8,7,11};
		int[] out = mergeSort(in);
		for(int i : out) {
			System.out.print(i+" ");
		}
	}

	private static int[] mergeSort(int[] inputArr) {
		int mid = inputArr.length/2;
		if(mid<1) {
			return inputArr;
		}
		int[] leftarr = new int[mid];
		int[] rightarr = new int[inputArr.length-mid];

		for(int i =0; i<mid; i++) {
			leftarr[i]= inputArr[i];
		}
		for(int i=mid; i<inputArr.length; i++) {
			rightarr[i-mid]= inputArr[i];
		}
		return merge(mergeSort(leftarr), mergeSort(rightarr));
	}

	private static int[] merge(int []a, int []b){
		int i = 0;
		int j = 0;
		int []out  = new int[a.length + b.length];

		for(int k=0 ; k<out.length ; k++){
			if(j==b.length && i<a.length){
				out[k] = a[i];
				i++;
			}
			else if (i==a.length && j<b.length){
				out[k] = b[j];
				j++;
			}
			else if(a[i] <= b[j]){
				out[k] = a[i];
				i++;
			}
			else if (b[j] < a[i]){
				out[k] = b[j];
				j++;
			}
		}
		return out;
	}
}
