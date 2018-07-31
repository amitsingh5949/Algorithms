package com.javaDwarf.gfg;

public class PolynomialAddition {

	/*public static Map<Integer,Integer> map = null;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i = 0; i<testCases; i++) {
			map = new HashMap<>();
			int size = s.nextInt();
			for(int j=0; j<size; j++) {
				int c = s.nextInt();
				int pow = s.nextInt();
				if(map.containsKey(pow)) {
					map.put(pow, map.get(pow)+c);
				}
				else {
					map.put(pow, c);
				}
			}
			int size2 = s.nextInt();
			for(int k=0; k<size2; k++) {
				int c = s.nextInt();
				int pow = s.nextInt();
				if(map.containsKey(pow)) {
					map.put(pow, map.get(pow)+c);
				}
				else {
					map.put(pow, c);
				}
			}
			Set<Integer>  set = map.keySet();
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list, Collections.reverseOrder());
			System.out.println();
			boolean flag = true;
			for(int x : list) {
				if(flag) {
					System.out.print(map.get(x)+"x^"+x);
					flag = false;
				}
				else {
					System.out.print(" + "+map.get(x)+"x^"+x);
				}
			}
		}
		s.close();
	}*/

	public static void main(String[] args) {

		Node1 c1 = new Node1(1,2);
		Node1 c2 = new Node1(1,3);
		addPolynomial(c1, c2);

		System.out.println();
		
		Node1 p1 = new Node1(1,3);	
		p1.next = new Node1(2,2);
		Node1 p2 = new Node1(3,3);	
		p2.next = new Node1(4,2);
		addPolynomial(p1, p2);
	}

	public static void addPolynomial(Node1 c1, Node1 c2){

		boolean flag = true;

		while(c1!=null || c2!=null) {

			if(c1==null || c2==null) {
				if(c1==null && c2!=null) {
					if(flag) {
						System.out.print(c2.coeff+"x^"+c2.pow);
						flag = false;
					}
					else {
						System.out.print(" + "+c2.coeff+"x^"+c2.pow);
					}
					c2 = c2.next;
				}
				else if(c1!=null && c2==null) {
					if(flag) {
						System.out.print(c1.coeff+"x^"+c1.pow);
						flag = false;
					}
					else {
						System.out.print(" + "+c1.coeff+"x^"+c1.pow);
					}
					c1 = c1.next;
				}
			}
			else {
				if(c1.pow > c2.pow) {
					if(flag) {
						System.out.print(c1.coeff+"x^"+c1.pow);
						flag = false;
					}
					else {
						System.out.print(" + "+c1.coeff+"x^"+c1.pow);
					}
					c1 = c1.next;
				}
				else if(c1.pow < c2.pow) {
					if(flag) {
						System.out.print(c2.coeff+"x^"+c2.pow);
						flag = false;
					}
					else {
						System.out.print(" + "+c2.coeff+"x^"+c2.pow);
					}
					c2 = c2.next;
				}
				else if(c1.pow == c2.pow) {
					if(flag) {
						System.out.print((c1.coeff+c2.coeff)+"x^"+c2.pow);
						flag = false;
					}
					else {
						System.out.print(" + "+(c1.coeff+ c2.coeff)+"x^"+c2.pow);
					}
					c1 = c1.next;
					c2 = c2.next;
				}
			}
		}
	}

}

class Node1{
	int coeff;
	int pow;
	Node1 next;
	Node1(int a,int b)
	{
		coeff=a;
		pow=b;
		next=null;
	}
}
