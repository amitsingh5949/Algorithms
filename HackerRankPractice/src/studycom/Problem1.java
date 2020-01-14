package studycom;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) throws Exception {
		MyClass c = new MyClass();
		//c.getValue("foo", 0);
		//c.getValue("bar", 2);
		c.getValue("baz", 0);
		//c.getValue("fubar", 1);

	}

}

class MyClass {
	private Map<String,Integer> map;

	public MyClass() {
		map = new HashMap<>();
		map.put("foo", 1);
		map.put("bar", 3);
	}

	public int getValue(String input, int numRetries) throws Exception {
		System.out.println(numRetries);
		try {
			return map.get(input);
		}
		catch (Exception e) {
			if (numRetries > 3) {
				throw e;
			}
			return getValue(input, numRetries + 1);
		}
	}
}
