package com.javadwarf.string.leetcode;

public class _1108_DefanginganIPAddress {

	public static void main(String[] args) {

	}

	public String defangIPaddr(String address) {
		for(int i=0; i<address.length(); i++) {
			if(address.charAt(i)=='.') {
				address = address.substring(0,i) + "[.]" + address.substring(i+1);
				i += 3;
			}
		}
		return address;
	}

}
