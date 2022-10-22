package com.javadwarf.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _379_DesignPhoneDirectory {

	public static void main(String[] args) {
	}

}

class PhoneDirectory {
    
    Set<Integer> assigned;
    Set<Integer> unAssigned;
    int maxNumbers;
    int curr = 0;

    public PhoneDirectory(int maxNumbers) {
        assigned = new HashSet<>();
        unAssigned = new HashSet<>();
        this.maxNumbers = maxNumbers;
        this.curr = 0;
    }
    
    public int get() {
        if(curr >= maxNumbers && unAssigned.size() == 0){
            return -1;
        }
        if(unAssigned.size() > 0){
            int num = unAssigned.iterator().next();
            unAssigned.remove(num);
            assigned.add(num);
            return num;
        }
        assigned.add(curr);
        return curr++;
    }
    
    public boolean check(int number) {
        return number <= maxNumbers && !assigned.contains(number);
    }
    
    public void release(int number) {
        if(number < curr){
            unAssigned.add(number);
            assigned.remove(number);
        }
    }
}
