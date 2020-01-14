package leetcodecontest.jan4;

public class Problem4 {

	public static void main(String[] args) {
		/*System.out.println(new Problem4().minInsertions("zzazz"));
		System.out.println(new Problem4().minInsertions("mbadm"));
		System.out.println(new Problem4().minInsertions("leetcode"));
		System.out.println(new Problem4().minInsertions("g"));
		System.out.println(new Problem4().minInsertions("no"));	
		System.out.println(new Problem4().minInsertions(""));*/
		
		
		System.out.println(new Problem4().minInsertions("ccewnxhytsr"));
	}


	public int  res = Integer.MAX_VALUE;
	public int minInsertions(String s) {
		rec(new StringBuilder(s), 0, s.length()-1, 0);
		return res;

	}

	public void rec (StringBuilder sb, int start, int end, int insertSoFar) {

		if(start >= end) {
			res = Math.min(res, insertSoFar);
			System.out.println(sb.toString());
			return;
		}

		if(sb.charAt(start) == sb.charAt(end)) {
			rec(sb,start+1, end-1, insertSoFar);
		}
		else {
			StringBuilder sb1  = new StringBuilder(sb); 
			sb1 = sb1.insert(start, sb.charAt(end));
			rec(sb1, start, end-1,insertSoFar+1);
			
			StringBuilder sb2  = new StringBuilder(sb); 
			sb2 = sb2.insert(end, sb.charAt(start));
			rec(sb2, start+1, end,insertSoFar+1);
		}

	}

}
