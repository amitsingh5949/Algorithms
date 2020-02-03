package enfusion;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		int operations_size = 0;
		operations_size = Integer.parseInt(in.nextLine().trim());

		String[] operations = new String[operations_size];
		for(int i = 0; i < operations_size; i++) {
			String operations_item;
			try {
				operations_item = in.nextLine();
			} catch (Exception e) {
				operations_item = null;
			}
			operations[i] = operations_item;
		}

		superStack(operations);
	}


	public static LinkedList<Integer> s1 = null;
	
	static void superStack(String[] operations) {
		s1 = new LinkedList<>();
		for(int  i=0; i<operations.length; i++) {
			runAlgo(operations[i].split(" "));
		}
	}

	static void runAlgo(String[] operations) {

		if(operations.length == 1) {
			if(s1.isEmpty()) {
				System.out.println("EMPTY");
			}
			else {
				s1.removeFirst();
				if(s1.isEmpty()) {
					System.out.println("EMPTY");
				}
				else {
					System.out.println(s1.peek());
				}
			}
		}
		else if(operations.length == 2) {
			int val = Integer.parseInt(operations[1]);
			s1.addFirst(val);
			System.out.println(val);
		}
		else if(operations.length == 3) {

			int i = Integer.parseInt(operations[1]);
			int v = Integer.parseInt(operations[2]);

			int k = s1.size()-1;
			for(int j=0; j<i && k>=0; j++,k--) {
				s1.set(k, s1.get(k)+v);
			}

			if(s1.isEmpty()) {
				System.out.println("EMPTY");
			}
			else {
				System.out.println(s1.peek());
			}

		}
	}

}
