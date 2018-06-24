package demo;

import java.io.IOException;
import java.util.Arrays;

public class Solution1 {

	static String findQualifiedNumbers(int[] numberArray) {
		String str ="";
		String[] strArr = new String[numberArray.length];
		int index = 0 ;
		String temp = "";
		for(int i=0; i<numberArray.length;i++){
			temp = Integer.valueOf(numberArray[i]).toString();
			if(temp.contains("1") && temp.contains("2") && temp.contains("3")){
				strArr[index++] = temp;
			}
		}
		if(index==0){
			return  Integer.valueOf(-1).toString();
		}

		int index1 = 0;
		int finalArr [] = new int[index];
		for(int i=0; i<strArr.length;i++){
			if(strArr[i] != null){
				finalArr[index1++] = new Integer(strArr[i]).intValue();

			}
		}
		Arrays.sort(finalArr);;
		boolean flag = true;
		for(int i = 0; i <finalArr.length; i++){
			if(flag){
				str = Integer.valueOf(finalArr[i]).toString();
				flag= false;
			}
			else{
				str = str +","+Integer.valueOf(finalArr[i]).toString();
			}
		}

		return str;
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
		int arr[] = {1456,345671,43218,123};
		System.out.println(findQualifiedNumbers(arr));
		/*bw.write(res);
		bw.newLine();

		bw.close();*/


	}



}
