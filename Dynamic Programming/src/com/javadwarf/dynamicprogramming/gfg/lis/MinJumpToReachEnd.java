package com.javadwarf.dynamicprogramming.gfg.lis;

public class MinJumpToReachEnd {

	public static void main(String[] args) {

		/*Scanner in = new Scanner(System.in);
		int numOfTest  = in.nextInt();

		for(int i=0; i<numOfTest; i++){
			int size = in.nextInt();
			int[] arr = new int[size];
			for(int j=0; j<size; j++){
				arr[j] = in.nextInt();
			}
			System.out.println(minJumpToReachEnd(arr));
		}
		in.close();*/

		System.out.println(minJumpToReachEnd(new int[]{1,3,5,8,9,2,6,7,6,8,9}));
	}
	public static int  minJumpToReachEnd(int[] a){

		int jump = 0;
		int x = a[0];
		int y = a[0];

		if(x != 0){
			for(int i=1; i<a.length;i++){
				x--;
				y--;
				if(y < a[i]){
					y = a[i];
				}
				if(x==0 && y==0){
					return -1;
				}
				else if(x==0 || i==a.length-1){
					x=y;
					jump++;
				}
			}
		}
		else{
			return -1;
		}
		return jump;
	}

	public static int  minJumpToReachEnd1(int[] a){

		int jump =0;
		int count = a[0];
		int currCount = a[0];
		int currJumPIndex = 0;

		for(int i=1; i<a.length;i=currJumPIndex+1){
			for(int j=i,k=1;j<i+count;j++,k++){
				if(j==a.length-1) {
					currCount = count -k +a[j];
					currJumPIndex = j;
					break;
				}
				int temp = count -k + a[j];
				if(temp>currCount){
					currCount = temp;
					currJumPIndex = j;
				}
			}
			jump++;
			count=currCount;
		}
		return jump;
	}

}
