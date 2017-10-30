package demo;

import java.io.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {


	static String whichSweetShouldIBring(String[] votes) {

		String result ="";

		java.util.Map<String, Integer> map = new  java.util.HashMap<String, Integer>();

		for(String temp : votes){

			if(map.containsKey(temp)){
				map.put(temp, map.get(temp)+1);	
			}
			else{
				map.put(temp, 1);
			}
		}

		Integer i = 0; 
		java.util.Set<java.util.Map.Entry<String, Integer>> set1 =  (java.util.Set<java.util.Map.Entry<String, Integer>>) map.entrySet();
		java.util.Iterator<java.util.Map.Entry<String, Integer>> itr1 = set1.iterator();
		
		while(itr1.hasNext()){
			java.util.Map.Entry<String, Integer> e  = itr1.next();
			if(e.getValue()>i){
				i=e.getValue();
			}
			
		}
		
		
		java.util.List<String> listkey = new java.util.ArrayList<String>() ;
		java.util.Set<java.util.Map.Entry<String, Integer>> set =  (java.util.Set<java.util.Map.Entry<String, Integer>>) map.entrySet();
		java.util.Iterator<java.util.Map.Entry<String, Integer>> itr = set.iterator();
		while(itr.hasNext()){
			java.util.Map.Entry<String, Integer> e  = itr.next();
			
			if(e.getValue()==i){
				listkey.add(e.getKey());
			}
		}
		
		java.util.Collections.sort(listkey,java.util.Collections.reverseOrder());
		 if(listkey.size()>0){
			 result = listkey.get(0);
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
		String arr[] = {"Gulab","Gajar","Gulab","Gajar"};
		System.out.println(whichSweetShouldIBring(arr));
		/*bw.write(res);
		bw.newLine();

		bw.close();*/


	}



}
