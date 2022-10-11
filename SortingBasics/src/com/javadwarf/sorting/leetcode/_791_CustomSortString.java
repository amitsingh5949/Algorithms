package com.javadwarf.sorting.leetcode;

public class _791_CustomSortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// using quick sort
	int[] arr = new int[26];

    public String customSortString(String order, String s) {
        
        for(int i=0;i<order.length(); i++){
            arr[order.charAt(i) - 'a'] = i+1;
        }

        char[] str = s.toCharArray();
        quicksort(str, 0, str.length-1);

        StringBuilder sb = new StringBuilder();
        for(char ch : str){
            sb.append(ch);
        }
        return sb.toString();
    }

    public void quicksort(char[] str, int start, int end){
        if(start >= end) return;
        int pivot = start + (end - start)/2;
        swap(str, pivot, end);
        int pos = helper(str, start, end);
        quicksort(str, start, pos-1);
        quicksort(str, pos+1, end);
    }

    public int helper(char[] str, int start, int end){
        int pivot = end;
        int left = start;
        int right = end-1;

        while(left <= right){
            if(arr[str[left] -'a'] <= arr[str[pivot]-'a']){
                left++;
            }
            else{
                swap(str, left, right);
                right--;
            }
        }
        swap(str, left, pivot);
        return left;
    }

    public void swap(char[] str, int start, int end){
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;
    }

}
