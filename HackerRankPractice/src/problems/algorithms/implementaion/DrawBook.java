package problems.algorithms.implementaion;

public class DrawBook {

	static int solve(int n, int p){
		
		int pageTurnStart = p/2;
		int pageTurnEnd = (n-p)/2;
		
		if(pageTurnStart <= pageTurnEnd){
			return pageTurnStart;
		}
		else{
			return pageTurnEnd;
		}
		
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();*/
        int result = solve(6, 2);
        System.out.println(result);
    }
	
}
