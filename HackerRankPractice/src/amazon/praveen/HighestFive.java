package amazon.praveen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HighestFive {
	
	public Map<Integer, Double> calculateHighestFive(int scoreCount, ArrayList<PairID> testScores){
		
		Map<Integer, Double> res = new HashMap<>();
		
		Map<Integer, PriorityQueue<Double>> scoreList = new HashMap<>();
		
		for(PairID testScore : testScores) {
			PriorityQueue<Double> l = scoreList.getOrDefault(testScore.id, new PriorityQueue<Double>(Collections.reverseOrder()));
			l.add(testScore.value);
			scoreList.put(testScore.id,l);
		}
		
		Set<Map.Entry<Integer, PriorityQueue<Double>>> set = scoreList.entrySet();
		Iterator<Map.Entry<Integer, PriorityQueue<Double>>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, PriorityQueue<Double>> e = itr.next();
			Integer id = e.getKey();
			Double value = 0.0d;
			
			PriorityQueue<Double> valtemp = e.getValue();
			
			for(int i=1; (i<=5 && !valtemp.isEmpty()); i++) {
				value += valtemp.poll();
			}
			value /= 5;
			res.put(id, value);
		}
		
		return res;
	}

}

class PairID{
	
	public int id;
	public double value;
	public PairID(int id, double value) {
		super();
		this.id = id;
		this.value = value;
	}
}
