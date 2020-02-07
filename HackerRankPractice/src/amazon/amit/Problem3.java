package amazon.amit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem3 {
	
	public ArrayList<String> topNCompetitors(int numCompetitors, 
            int topNCompetitors, 
            List<String> competitors, 
			 int numReviews, 
			 List<String> reviews){
		
		ArrayList<String> res = new ArrayList<>();
		Set<String> setToys = new HashSet<>();
		Map<String, WordStats> mapWords = new HashMap<>(); 
		
		for (int i = 0; i < numCompetitors; i++)
			setToys.add(competitors.get(i));

		for (int i = 0; i < numReviews; i++)
		{
			String q = reviews.get(i);
			q = q.replaceAll("[\\!?,;.]", "").toLowerCase();
			String[] words = q.split(" ");
			
			for (int w = 0; w < words.length; w++)
			{
				String word = words[w];
				if (setToys.contains(word))
				{
					WordStats stats;
					if (mapWords.containsKey(word))
						stats = mapWords.get(word);
					else
						stats = new WordStats(word, 0);
					stats.countTimes++;
					stats.quotesIds.add(i);
					mapWords.put(word, stats);
				}
			}
		}

		PriorityQueue<WordStats> pq = new PriorityQueue<WordStats>(new Comparator<WordStats>() {
			@Override
			public int compare(WordStats o1, WordStats o2) {
				if (o1.countTimes != o2.countTimes)
					return Integer.compare(o2.countTimes, o1.countTimes);
				else if (o1.quotesIds.size() != o2.quotesIds.size())
					return Integer.compare(o2.quotesIds.size(), o1.quotesIds.size());
				else
					return o1.word.compareTo(o2.word);
			}
		});
		pq.addAll(mapWords.values());

		if (topNCompetitors > pq.size())
			for (int i = 0; i < numCompetitors && !pq.isEmpty(); i++)
				res.add(pq.poll().word);
		else
			for (int i = 0; i < pq.size(); i++)
				res.add(pq.poll().word);

		return res;
	}
		
	}





class WordStats {
	String word;
	int countTimes;
	Set<Integer> quotesIds;
	public WordStats(String word, int countTimes) {
		this.word = word;
		this.countTimes = countTimes;
		this.quotesIds = new HashSet<>();
	}
}