	package demo;

import java.io.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution4 {


	static int maximalDifference(int[] a) {

		int result = -1;
		
		for(int i=0; i<a.length;i++){
			for(int j=i+1; j<a.length;j++){
				
				if(a[i] < a[j] && ((a[j] - a[i]) > result)){
					result = (a[j] - a[i]);
				}
				
			}
		}
		return result;
    }


	public static void main(String[] args) throws IOException {

		/*Scanner in = new Scanner(System.in);
		//final String fileName = System.getenv("OUTPUT_PATH");
		final String fileName ="C:/Users/Amit Singh/Desktop/Interview/hacker rank/output.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String res=null;*/

		/*	int _arr_size = 0;
		_arr_size = Integer.parseInt(in.nextLine().trim());
		int[] _arr = new int[_arr_size];
		int _arr_item;
		for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++){
			_arr_item = Integer.parseInt(in.nextLine().trim());
			_arr[_arr_i] = _arr_item;
		}

		int _k;
		_k = Integer.parseInt(in.nextLine().trim());

		res =  findNumber(_arr, _k);
		 */
		int arr[] = {5,4,3,2,1};
		System.out.println(maximalDifference(arr));
		/*bw.write(res);
		bw.newLine();

		bw.close();*/


	}



}
