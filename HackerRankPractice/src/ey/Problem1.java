package ey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {
	/**
	 * Iterate through each line of input.
	 */

	public static Map<String, String> map = null;
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);


		map = new HashMap<>();
		map.put("IOException","High|100");
		map.put("MemoryException","High|110");
		map.put("ThreadAbortException","Medium|200");
		map.put("ResponseTimeoutException","Low|300");
		map.put("ParameterException","Low|301");

		String line;

		while ((line = in.readLine()) != null) {
			//System.out.println(line);
			String[] arr = line.split("\\|");
			System.out.println( map.get(arr[0]) + "|" + line);
		}
	}
}