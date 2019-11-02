package com.javadwarf.string.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _929_UniqueEmailAddresses {

	public static void main(String[] args) {

		String[] arr = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};

		System.out.println(new _929_UniqueEmailAddresses().numUniqueEmails(arr));

	}

	public int numUniqueEmails(String[] emails) {

Map<String,Set<String>> map = new HashMap<>();
		
		for(String email : emails) {
			String[] arr = email.split("@");
			
			String localName = arr[0];
			
			int index = localName.indexOf('+');
			if(index != -1) {
				localName = localName.substring(0,index);
			}
            if(localName.contains(".")) {
				localName = localName.replaceAll(".", "");
			}
			
			Set<String> val = map.getOrDefault(arr[1], new HashSet<>());
			val.add(localName);
			map.put(arr[1], val);
		}
		
		int res =0 ;
		
		for(Collection<String> val : map.values()) {
			res += val.size();
		}
		
		return res;



	}

}
