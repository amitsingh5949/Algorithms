package amazon.harsh;

import java.util.List;


public class Problem1 {

	public static void main(String[] args) {

	}
	
	PairInt locationOfTargetValue(int rowCount, int columnCount, List<List<Integer>> matrix, int targetValue ) {
		
		PairInt result = new PairInt(-1,-1);
		
		if(matrix == null|| rowCount== 0|| columnCount == 0) return result;

		int i = columnCount;
		int j = 0;

		while(i>=0 && j<columnCount){

			if(matrix.get(i).get(j) == targetValue) {
				return new PairInt(i,j);
			}
			else if(matrix.get(i).get(j) < targetValue ) {
				j++;
			}
			else {
				i--;
			}
		}
		return result;
		
	}
	
	
	class PairInt{
		int first;
		int second;
		
		
		public PairInt() {
			super();
		}
		public PairInt(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		
	}

}
