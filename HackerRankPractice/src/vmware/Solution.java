package vmware;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {

	private static String findNumber(int[] _arr, int _k) {
		String str = "NO";
		
		for(int i = 0; i < _arr.length; i++){
			if(_arr[i] == _k){
				str = "YES";
				break;
			}
		}
		return str;
	}


	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		//final String fileName = System.getenv("OUTPUT_PATH");
		final String fileName ="C:/Users/Amit Singh/Desktop/Interview/hacker rank/output.txt";
		//BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String res;

		int _arr_size = 0;
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
		bw.write(res);
		bw.newLine();
		
		bw.close();


	}



}
