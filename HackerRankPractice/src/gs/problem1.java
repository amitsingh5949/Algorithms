package gs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class problem1 {

	public static void main(String[] args) {
		
		/*List<Integer> mapping = new ArrayList<Integer>();
		mapping.add(3);
		mapping.add(5);
		mapping.add(4);
		mapping.add(6);
		mapping.add(2);
		mapping.add(7);
		mapping.add(9);
		mapping.add(8);
		mapping.add(0);
		mapping.add(1);
		
		 List<String> nums = new ArrayList<String>();
		 nums.add("990");
		 nums.add("");
		 nums.add("332");
		 nums.add("32");
		 nums.add("");
		 
		 List<String> ans = strangeSort(mapping, nums);
		 System.out.println(ans);*/
		 
		 List<Integer> mapping = new ArrayList<Integer>();
			mapping.add(0);
			mapping.add(1);
			mapping.add(2);
			mapping.add(3);
			mapping.add(4);
			mapping.add(5);
			mapping.add(6);
			mapping.add(7);
			mapping.add(8);
			mapping.add(9);
			
			 List<String> nums = new ArrayList<String>();
			 nums.add("180");
			 nums.add("84");
			 nums.add("99");
			 nums.add("003");
			 nums.add("53");
			 nums.add("28");
			 nums.add("60");
			 nums.add("60773563263526354665566665422222222222222222");
			 nums.add("1");
			 
			 List<String> ans = strangeSort(mapping, nums);
			 System.out.println(ans);
		

	}

	public static List<String> strangeSort(List<Integer>  mapping, List<String> nums){
		
		List<BigInteger> resList = new ArrayList<>();
		
		for(String temp: nums) {
			String resStr = "";
			for(int i=0; i<temp.length(); i++) {
				Integer ch = Integer.valueOf(""+temp.charAt(i));
				int index = mapping.indexOf(ch);
				resStr += index;
			}
			
			BigInteger bi = new BigInteger(resStr);
			resList.add(bi);
		}

		List<BigInteger> resListDup = new ArrayList<BigInteger>(resList);
		Collections.sort(resListDup);
		
		List<String> ans = new ArrayList<String>();
		
		for(BigInteger temp : resListDup) {
			int index = resList.indexOf(temp);
			ans.add(nums.get(index));
			resList.set(index, new BigInteger(Integer.valueOf(-1).toString()));
		}

		return ans;
	}

}
