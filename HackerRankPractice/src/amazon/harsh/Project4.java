package amazon.harsh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project4 {

	public static void main(String[] args) {

	}



	/*
	 * Complete the 'routePairs' function below.
	 *
	 * The function is expected to return a 2D_INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. INTEGER maxTravelDist
	 *  2. 2D_INTEGER_ARRAY forwardRouteList
	 *  3. 2D_INTEGER_ARRAY returnRouteList
	 */

	public static List<List<Integer>> routePairs(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {

		Collections.sort(forwardRouteList,  (o1,o2) -> Integer.compare(o1.get(1),o2.get(1)));
		Collections.sort(returnRouteList,  (o1,o2) -> Integer.compare(o1.get(1),o2.get(1)));

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		int i=0;
		int j = returnRouteList.size()-1;
		
		int distance = Integer.MIN_VALUE;
		int forwardRoute = Integer.MIN_VALUE;
		int returnRoute = Integer.MIN_VALUE;

		while(i<forwardRouteList.size() && j>=0) {
			
			List<Integer> currForward = forwardRouteList.get(i);
			List<Integer> currReturn= returnRouteList.get(j);
			
			int totalDistance  = currForward.get(1) + currReturn.get(1);
			
			if(totalDistance == maxTravelDist) {
				List<Integer> currFinding = new ArrayList<Integer>();
				currFinding.add(currForward.get(0));
				currFinding.add(currReturn.get(0));
				result.add(currFinding);
				i++;
				j--;
			}
			else if(totalDistance > maxTravelDist) {
				j--;
			}
			else {
				if(totalDistance > distance) {
					distance= totalDistance;
					forwardRoute= currForward.get(0);
					returnRoute = currReturn.get(0);
				}
				i++;
			}

		}
		
		if(result.size() == 0) {
			List<Integer> currFinding = new ArrayList<Integer>();
			currFinding.add(forwardRoute);
			currFinding.add(returnRoute);
			result.add(currFinding);
		}


		return result;

	}



}
