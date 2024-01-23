package com.javadwarf.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _202_HappyNumber {

	public static void main(String[] args) {

	}

	// Detecting cycle using hashSet
	
	public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n) && n != 1){
            set.add( n);
            int x = 0;
            while( n > 0){
                int y = n % 10;
                x += y*y;
                n = n/10;
            }
            n = x;
        }
        return n==1;        
    }
	// same as above 
	public boolean isHappy1(int n) {
		String res = Integer.valueOf(n).toString();
		Set<Integer> set = new HashSet<>();
		set.add(n);

		while(!res.equals("1")) {
			int temp = 0;
			for(int i=0; i<res.length(); i++) {
				temp +=  (res.charAt(i) -'0') * (res.charAt(i) -'0');
			}

			if(set.contains(temp)) {
				return false;
			}
			set.add(temp);
			res = Integer.valueOf(temp).toString();
		}
		return true;
	}

	//cycle detection using floyd tortoise and hare algorithm
	public boolean isHappy2(int n) {
		
		int slow = n;
		int fast = getNext(n);
		
		while(fast != 0 || slow != fast) {
			 slow = getNext(slow);
			 fast = getNext(getNext(fast));
		}

		return fast==0;
	}

	public int getNext(int n) {
		int temp = 0;
		while(n!=0) {
			temp += (n%10)*(n%10);
			n = n/10;
		}
		return temp;
	}




}
