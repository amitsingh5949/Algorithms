package purestorage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Problem1 {

	public static void main(String[] args) {
		
		List<String> l = new ArrayList<>();
		l.add("ACQUIRE 123");
		l.add("ACQUIRE 364");
		l.add("ACQUIRE 84");
		l.add("RELEASE 84");
		l.add("RELEASE 364");
		l.add("ACQUIRE 789");
		l.add("RELEASE 456");
		l.add("RELEASE 123");
		
		
		
		
		System.out.println(check_log_history(l));
		
		
	}

	static int check_log_history(List<String> events) {
		
		int x = 0;
		
		Stack<String> stack = new Stack<>();
		Set<String> set = new HashSet<>();
		
		
		for(int i= 0; i<events.size(); i++) {
			String temp = events.get(i);
			
			String[] arr = temp.split(" ");
			
			if(arr[0].equals("ACQUIRE")) {
				if(!set.contains(arr[1])) {
					stack.push(arr[1]);
					set.add(arr[1]);
				}
				else {
					return i+1;
				}
			}
			else {
				if(set.contains(arr[1])) {
					if(stack.peek().equals(arr[1])) {
						stack.pop();
						set.remove(arr[1]);
					}
					else {
						return i+1;
					}
				}
				else {
					return i+1;
				}
			}
		}
		if(!stack.isEmpty()) {
			return events.size()+1;
		}
		return x;
    }

}