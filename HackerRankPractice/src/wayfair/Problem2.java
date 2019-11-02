package wayfair;

import java.util.PriorityQueue;
import java.util.Queue;

public class Problem2 {

	public static void main(String[] args) {
		System.out.println(new Problem2().solution(6, 1, 1));
	}

	public String solution(int A, int B, int C) {

		String res = "";

		Queue<Pos> q = new PriorityQueue<Pos>();
		if(A != 0)
		q.add(new Pos(A, 'a'));
		if(B != 0)
		q.add(new Pos(B,'b'));
		if(C != 0)
		q.add(new Pos(C,'c'));


		while(!q.isEmpty()) {
			Pos pos1 = q.poll();

			Pos pos2 = null;

			if(!q.isEmpty()) {
				pos2 = q.poll();
			}

			if(pos1.count >= 2) {
				res += pos1.ch;
				res += pos1.ch;
				pos1.count -= 2;
				q.add(pos1);
			}
			else {
				res += pos1.ch;
			}


			if(pos2 != null) {
				if(pos2.count >= 2) {
					res += pos2.ch;
					res += pos2.ch;
					pos2.count -= 2;
					q.add(pos2);
				}
				else {
					res += pos2.ch;
				}
			}

		}
		res = truncate(res);
		return res;
	}

	public String truncate(String S) {

		if(S == null || S.length() < 3) return S;

		String res = S.charAt(0)+"";

		int count = 1;
		char current = S.charAt(0);

		for(int i= 1; i<S.length(); i++) {

			char temp = S.charAt(i);

			if(temp == current) {

				if(count < 2) {
					res += temp;
					count++;
				}
				else {
					continue;
				}
			}
			else {
				res += temp;
				current = temp;
				count = 1;
			}
		}

		return res;
	}

	class Pos implements Comparable<Pos>{

		int count = 0;
		char ch = '\0';

		public Pos(int count, char ch) {
			super();
			this.count = count;
			this.ch = ch;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(o.count, this.count);
		}


	}

}
