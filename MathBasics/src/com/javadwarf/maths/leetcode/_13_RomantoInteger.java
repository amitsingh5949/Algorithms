
package com.javadwarf.maths.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _13_RomantoInteger {
	//MMMCMXCIX - 3999 max roman numeral
	public static void main(String[] args) {
		System.out.println(new _13_RomantoInteger().romanToInt("LVIII"));
	}


	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);


		int sum = map.get(s.charAt(0)); 

		for( int i=1; i<s.length(); i++){

			char ch1 = s.charAt(i-1);
			char ch2 = s.charAt(i);

			if(map.get(ch1) >= map.get(ch2)){
				sum += map.get(ch2);
			}
			else{
				sum += map.get(ch2) - 2*map.get(ch1); //MCM (1000) + (100) + (1000-2*100)
			}

		}
		return sum;
	}

	// leetcode solution, hard to understand
	public int romanToInt1(String s) {

		int[] arr = new int[s.length()];

		for(int i=0; i<s.length(); i++) {

			char ch = s.charAt(i);

			if(ch  == 'I')
				arr[i] = 1;
			else if(ch  == 'V')
				arr[i] = 5;
			else if(ch  == 'X')
				arr[i] = 10;
			else if(ch  == 'L')
				arr[i] = 50;
			else if(ch  == 'C')
				arr[i] = 100;
			else if(ch  == 'D')
				arr[i] = 500;
			else if(ch  == 'M')
				arr[i] = 1000;
		}


		int sum = 0;

		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] < arr[i+1] ) {
				sum  -= arr[i];
			}
			else {
				sum += arr[i];
			}
		}

		return sum + arr[arr.length-1];
	}

}

/*// one more approach form leetcode discussion to add zero at end
 * def romanToInt(self, s: str) -> int:
        h = {"I": 1, "V":5, "X":10, "L":50, "C":100, "D":500, "M":1000, "Z":0}
        total = 0
        s = s + 'Z'
        for i in range(len(s)-1):
            if h[s[i]] < h[s[i+1]]:
                total -= h[s[i]]
            else:
                total += h[s[i]]
        return total
 */

