package com.javadwarf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _15_ThreeSum {

	public static void main(String[] args) {
		/*System.out.println(threeSum2(new int[] {-1, 0, 1, 2, -1, -4}));
		System.out.println(threeSum1(new int[] {0,0,0}));
		System.out.println(threeSum2(new int[] {-2,0,0,2,2}));
		System.out.println(threeSum2(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));

		System.out.println();

		System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));

		System.out.println(threeSum(new int[] {-2,0,0,2,2}));
		System.out.println(threeSum(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));*/

		//System.out.println(threeSum(new int[] {0,0,0}));
		//System.out.println(threeSum(new int[] {0,0,0,0}));

		System.out.println(threeSum(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));

		//System.out.println( 4 ^-4 ^-2 ^ 6);

	}
	
	 public static List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(nums.length < 3) return result;
	        Arrays.sort(nums);
	        int i = 0;
	        while(i < nums.length - 2) {
	            if(nums[i] > 0) break;
	            int j = i + 1;
	            int k = nums.length - 1;
	            while(j < k) {
	                int sum = nums[i] + nums[j] + nums[k];
	                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
	                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
	                if(sum >= 0) while(nums[k--] == nums[k] && j < k);
	            }
	            while(nums[i] == nums[++i] && i < nums.length - 2);
	        }
	        return result;
	    }

	public static List<List<Integer>> threeSum3(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();

		Arrays.sort(nums);

		for(int i = 0; i<nums.length;i++) {

			int sum = nums[i] * -1;

			int start = i + 1;
			int end = nums.length-1;

			while(start < end) {

				int temp = nums[start] + nums[end];
				if( temp==sum) {
					List<Integer> l = new ArrayList<>();
					l.add(nums[i]);
					l.add(nums[start]);
					l.add(nums[end]);
					list.add(l);
					start++;
					end--;
				}
				 if (temp < sum) {
					start++;
					while(start < end && nums[start]==nums[start+1]) {
						start++;
					}
				}
				 if (temp > sum)  {
					end--;
					while(start < end && nums[end]==nums[end-1]) {
						end--;
					}
				}

			}
			while( i < nums.length-1 && nums[i]==nums[i+1]) {
				i++;
			}
		}

		return list;
	}

	public static List<List<Integer>> threeSum2(int[] nums) {
		Set<List<Integer>> list = new HashSet<>();

		Arrays.sort(nums);

		for(int i = 0; i<nums.length;i++) {
			int sum = nums[i] * -1;

			int start = i +1;
			int end = nums.length-1;

			while(start < end) {
				int temp = nums[start] + nums[end];
				if( temp==sum) {
					List<Integer> l = new ArrayList<>();
					l.add(nums[i]);
					l.add(nums[start]);
					l.add(nums[end]);
					list.add(l);
					start++;
					end--;
				}
				else if (temp < sum) {
					start++;
				}
				else {
					end--;
				}
			}
		}

		List<List<Integer>> result = new ArrayList<>(list);

		return result;
	}


	public static List<List<Integer>> threeSum1(int[] nums) {

		List<List<Integer>> list = new ArrayList<>();

		if(nums==null || nums.length ==0) return list; 

		for(int i =0;i<nums.length; i++) {
			List<List<Integer>> temp = twoSum(nums,i);
			if(temp.size() > 0) {
				list.addAll(temp);
			}
		}

		List<List<Integer>> result = new ArrayList<>();

		for(int i=0 ; i<list.size(); i++) {

			List<Integer> X = list.get(i);
			boolean isUnique = true;

			for(int j=i+1 ; j<list.size(); j++) {
				List<Integer> Y = list.get(j);
				int xor = 0;
				for(int k =0; k<3; k++) {
					xor ^= X.get(k) ;
					xor ^= Y.get(k);
				}
				if(xor==0) {
					isUnique = false;
				}
			}

			if(isUnique) {
				result.add(X);
			}
		}


		return result;


	}

	public static List<List<Integer>> twoSum(int[] nums, int currIndex){
		List<List<Integer>> list = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();

		for(int i = currIndex+1; i<nums.length; i++) {

			int sum =  nums[currIndex] * -1;
			if(map.containsKey(nums[i]) && map.get(nums[i])==1 ) {
				if(map.get(nums[i]) * 2 == sum) {

					List<Integer> l = new ArrayList<>();
					l.add(nums[currIndex]);
					l.add(nums[i]);
					l.add(nums[i]);
					list.add(l);
				}
				else {
					map.put(nums[i], map.get(nums[i]) + 1);
				}

			}

			if(map.containsKey(sum - nums[i]) ) {
				List<Integer> l = new ArrayList<>();
				l.add(nums[currIndex]);
				l.add(nums[i]);
				l.add(sum - nums[i]);
				list.add(l);
			}
			map.put(nums[i],1);
		}



		return list;
	}

}
