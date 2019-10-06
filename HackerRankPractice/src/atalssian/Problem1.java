package atalssian;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

	public static void main(String[] args) {

	}
	public static int minimumGroups(List<Integer> predators) {

		int maxVal = 1;
		int i = 0;
		while(i < predators.size()) {
			int temp = i++;
			int curr = 1;
			while (curr < predators.size() && 
					predators.get(temp) < predators.size() && 
					predators.get(temp) > -1){
				temp = predators.get(temp);
				curr++;
			}
			if (curr > maxVal) maxVal = curr;
		}
		return maxVal;

	}

	public static int minimumGroups2(List<Integer> predators) {

		int max = 1;
		int arrLen = predators.size();
		for (int i = 0; i < predators.size(); i++)
		{
			int a = i;
			int counter = 1;
			while (predators.get(a) > -1 && predators.get(a) < arrLen && counter < arrLen)
			{
				a = predators.get(a);
				counter++;
			}

			if (counter > max)
				max = counter;
		}
		return max;

	}

	public static int minimumGroups1(List<Integer> predators) {

		int maxVal = 1;

		List<Integer> visited = new ArrayList<>();

		int depth = 1;

		for (int i = 0; i < predators.size(); i++){

			int a = i;
			int currCount = depth;

			if (visited.contains(predators.get(a))){
				currCount = (int)visited.get(predators.get(a)) + 1;
				if (currCount > maxVal) {
					maxVal = currCount;
				}
				visited.add(i, currCount);
				continue;
			}

			while (predators.get(a) > -1){
				currCount++;
				a = predators.get(a);
			}

			visited.add(i, currCount);
			if (currCount > maxVal)
				maxVal = currCount;
		}

		return maxVal;

	}

}
