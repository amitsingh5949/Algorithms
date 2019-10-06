package gs.vinay;

import java.util.Arrays;
import java.util.List;

public class Problem1 {

	public static void main(String[] args) {
		Integer[] arr1 =  {1,0};
		List<Integer> l1 = Arrays.asList(arr1);

		Integer[] arr2 =  {7,4};
		List<Integer> l2 = Arrays.asList(arr2);

		System.out.println(rotateTheString("ephjos", l1, l2));

		//System.out.println(4%5);
	}

	static String leftrotate(String str, int d){ 
		return  str.substring(d) + str.substring(0, d); 
	} 

	static String rightrotate(String str, int d, int len) { 
		return str.substring(len - d) + str.substring(0, len - d); 
	} 

	public static String rotateTheString(String originalString, List<Integer> directions, List<Integer> amount){
		
		int len = originalString.length();

		for(int i=0; i<directions.size();i++) {
			if(directions.get(i) == 0) {
				originalString = leftrotate(originalString, amount.get(i)%len);
			}
			else {
				originalString = rightrotate(originalString, amount.get(i)%len, len);
			}
		}
		return originalString;
	} 

}
/*
def leftRotate(s, no):
    temp = ""
    temp += s[no:]
    temp += s[:no]
    return temp

def rightRotate(s, no,lens):
    temp = ""
    temp += s[lens-no:]
    temp += s[0:lens-no]
    return temp

def stringRotation(originalString, direction, amount):
    lens = len(originalString)
    for i in range(len(direction)):
        if direction[i] == 0:
            originalString = leftRotate(originalString, amount[i] % lens)
        else:
            originalString = rightRotate(originalString, amount[i] % lens, lens)
    return originalString
    
    */
