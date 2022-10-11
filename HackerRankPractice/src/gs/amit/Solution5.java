	package gs.amit;

import java.io.IOException;

public class Solution5 {


	static int shaktimaan(int[] power) {

		int sum =0;
		int currpower = 0;
		for(int i=0; i<power.length;i++){
			if(currpower+power[i]<1){
				sum += Math.abs(currpower + power[i]) +1;
				currpower=sum;
				currpower = Math.abs(currpower+power[i]) ;
			}
			else{
				currpower += power[i];
			}
		}
		
		return sum;
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
		int arr[] = {-5,4,-2,3,1,-1,-6,-1,0,5};
		System.out.println(shaktimaan(arr));
		/*bw.write(res);
		bw.newLine();

		bw.close();*/


	}



}
