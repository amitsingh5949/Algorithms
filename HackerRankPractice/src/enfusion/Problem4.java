package enfusion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Problem4 {
	
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		String fileName = scan.nextLine();
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter writer = new BufferedWriter(new FileWriter("req_"+fileName));
		String line;
		Map<String, Integer> map = new HashMap<>();
		while((line = br.readLine()) != null){
			int start = line.indexOf('[');
			int end = line.indexOf(']');
			String time = line.substring(start+1, end-5);
			int count = map.getOrDefault(time, 0);
			map.put(time, count+1);
		}
		List<String> res = new ArrayList<>();
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Iterator<Map.Entry<String, Integer>> itr = set.iterator();
		
		while(itr.hasNext()) {
			Map.Entry<String, Integer> e = itr.next();
			if(e.getValue()>1) {
				res.add(e.getKey());
			}
		}
		Collections.sort(res);
		for(String temp : res) {
			writer.write(temp);
			writer.newLine();
		}
		br.close();
		writer.close();
	}

}
