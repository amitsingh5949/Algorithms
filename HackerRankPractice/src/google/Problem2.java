package google;

public class Problem2 {

	public static void main(String[] args) {

	}
	
	public static String solution(String T) {
		char[] timChar = T.toCharArray();

	    if(timChar[0] == '?')
	        timChar[0] = (timChar[1] <= '3' || timChar[1] == '?') ? '2' : '1';

	    if(timChar[1] == '?')
	        timChar[1] = (timChar[0] == '2') ? '3' : '9';

	    timChar[3] = (timChar[3] == '?') ? '5' : timChar[3];
	    timChar[4] = (timChar[4] == '?') ? '9' : timChar[4];

	    String res = "";
	    for(char ch : timChar) {
	    	res  += ch;
	    }
	    return res;
	}

}
