package gs.amit;

import java.io.IOException;

public class Solution2 {

	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		int patternFinal = -1;
		
		String str = "";
		char[] arr = pattern.toCharArray();
		
		for(int i=0; i<arr.length;i++){
			char ch = arr[i];
			
			if(ch == 'M'){
				if(str.equals("")){
					str = "21";
				}
				else{
					str = addString(str, 'M');
				}
			}
			
			if(ch == 'N'){
				if(str.equals("")){
					str = "12";
				}
				else{
					str = addString(str, 'N');
				}
			}
        }
		if(!str.equals("")){
			patternFinal  = Integer.parseInt(str);
		}
		return patternFinal;
	}

	
	static String addString(String str, char c){
		
		int[] arr = new int[str.length()];
		for(int i=0; i<arr.length;i++){
			arr[i] = Character.getNumericValue(str.charAt(i));
        }
		
		
		int lst = arr[arr.length-1];
		int currIndex = arr.length-1;
		
		int addDigit = -1;
		
		if(c=='M'){
			addDigit = lst-1;
			boolean flag = canBeAdded(str, addDigit);
			if(flag){
				str = str+addDigit;
			}
			else{
				while(currIndex >0 ){
					if(arr[currIndex-1]>arr[currIndex]){
						arr[currIndex] =arr[currIndex] +1;
					}
					else if(arr[currIndex-1]==arr[currIndex]){
						arr[currIndex-1] = arr[currIndex-1]+1;
					}
					else if(arr[currIndex-1]>arr[currIndex]){
						break;
					}
					currIndex--;
				}
			}
			
			
		}
		
		if(c=='N'){
			addDigit = lst+1;
			boolean flag = canBeAdded(str, addDigit);
		
			if(flag){
				str = str + addDigit;
			}
			else{
				
				 boolean temp =  canBeAdded(str, addDigit);
				while(temp == false){
					addDigit = addDigit +1;
					temp = canBeAdded(str, addDigit);
				}
				if(temp){
					str = str + addDigit;
				}
			}
		}
		
		str="";
		for(int t : arr){
			str = ""+t;
		}
		str =str+addDigit;
		return str;
	}
	
	static boolean canBeAdded(String str, int addDigit){
		boolean flag = false;
		if(addDigit<=0 || addDigit >9 || (str.contains(Integer.valueOf(addDigit).toString()) == false)){
			return true;
		}
		return flag;
	}

	public static void main(String[] args) throws IOException {

		String str= "MNM";
		System.out.println(findPossibleSmallestNumberMatchingPattern(str));


	}



}
