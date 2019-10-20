package amex;

public class Problem2 {

	public static void main(String[] args) {
		System.out.println(solution(8, 0));
		System.out.println(solution(18, 2));
		System.out.println(solution(10, 10));
		
		System.out.println(solution(100, 6));
	}

	public static int finalMoves = Integer.MAX_VALUE;
	public static int solution(int N, int K) {
		finalMoves = Integer.MAX_VALUE;
		betDfs(N,K,1,2);
		return finalMoves;
	}

	public static void betDfs(int N, int K, int moves, int currSum) {
		if(N<currSum) {
			return;
		}
		if(N == currSum) {
			finalMoves = Math.min(finalMoves, moves);
			return;
		}

		betDfs(N,K,moves+1,currSum+1);
		if(K!=0) {
			betDfs(N,K-1,moves+1,currSum*2);
		}
	}

}
