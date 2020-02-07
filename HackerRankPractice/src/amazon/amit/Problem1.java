package amazon.amit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Problem1 {

	public ArrayList<String> topNCompetitors(int numCompetitors, 
			int topNCompetitors, 
			List<String> competitors, 
			int numReviews, 
			List<String> reviews){

		System.out.println(numCompetitors + "- " + topNCompetitors + "-" + competitors + " -" + numReviews + " -" + reviews);

		ArrayList<String> result = new ArrayList<>();
		Map<String, Word> map = new HashMap<>();

		Set<String> competitorSet = new HashSet<>();
		for(String competitor : competitors) {
			competitorSet.add(competitor.toLowerCase());
		}

		for(int i=0; i<numReviews; i++) {
			String review = reviews.get(i);
			review = review.replaceAll("[\\!?,;.]", "").toLowerCase();

			String[] words = review.split(" ");

			boolean found = false;

			for(String word : words) {

				if(competitorSet.contains(word)) {
					if(map.containsKey(word)){
						Word currWord  = map.get(word);
						if(!found) {
							currWord.count +=1;
							found = true;
						}
						currWord.reviewId.add(i);
						map.put(word, currWord);
					}
					else{
						Set<Integer> set  = new HashSet<>();
						set.add(i);
						map.put(word, new Word(word,1,set));
						found = true;
					}
				}
			}
		}

		Collection<Word> values = map.values();
		List<Word> valuesList = new ArrayList<>(values);
		Collections.sort(valuesList);

		for(int i=0;i<topNCompetitors && i<valuesList.size(); i++) {
			result.add(valuesList.get(i).word);
		}
		return result;
	}
}

class Word implements Comparable<Word>{
	public String word;
	public int count;
	public Set<Integer> reviewId;

	public Word(String word, int count, Set<Integer> quoteId) {
		super();
		this.word = word;
		this.count = count;
		this.reviewId = quoteId;
	}

	@Override
	public int compareTo(Word o) {
		int x = Integer.compare(o.count, this.count);
		if(x == 0) {
			int y = Integer.compare(o.reviewId.size(), this.reviewId.size());
			if(y == 0) {
				return this.word.compareTo(o.word);
			}
			return y;
		}
		return x;
	}
}
