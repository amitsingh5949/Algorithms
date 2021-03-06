package amazon.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopNBuzzWord {

	public static void main(String[] args) {

		int numToys = 6;
		int topToys = 2;
		String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
		int numQuotes = 6;
		String[] quotes = {
				"Emo is the hottest of the season! Elmo will be on every kid's wishlist!",
				"The new Elmo dolls are super high quality",
				"Expect the Elsa dolls to be very popular this year",
				"Elsa and Elmo are the toys I'll be buying for my kids",
				"For parents of older kids, look into buying them a drone",
		"Warcraft is slowly rising in popularity ahead of the holiday season"};
		List<String> result = TopNBuzzWord.topNBuzzwords(numToys, topToys, toys, numQuotes, quotes);
		System.out.println(result.toString());

	}

	private static List<String> topNBuzzwords1(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {

		List<String> result = new ArrayList<>();
		Map<String, Word> map = new HashMap<>();

		Set<String> toysSet = new HashSet<>();
		for(String toy : toys) {
			toysSet.add(toy.toLowerCase());
		}

		for(int i=0; i<numQuotes; i++) {
			String quote = quotes[i];
			quote = quote.replaceAll("[\\!?,;.]", "").toLowerCase();

			String[] words = quote.split(" ");

			for(String word : words) {

				if(toysSet.contains(word)) {
					if(map.containsKey(word)){
						Word currWord  = map.get(word);
						currWord.count +=1;
						currWord.quoteId.add(i);
						map.put(word, currWord);
					}
					else{
						Set<Integer> set  = new HashSet<>();
						set.add(i);
						map.put(word, new Word(word,1,set));
					}
				}
			}
		}

		Collection<Word> values = map.values();
		List<Word> valuesList = new ArrayList<>(values);
		Collections.sort(valuesList);

		for(int i=0;i<topToys && i<valuesList.size(); i++) {
			result.add(valuesList.get(i).word);
		}
		return result;
	}
	
	private static List<String> topNBuzzwords(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
		List<String> res = new ArrayList<>();
		Set<String> setToys = new HashSet<>();
		Map<String, WordStats> mapWords = new HashMap<>(); 
		
		for (int i = 0; i < numToys; i++)
			setToys.add(toys[i]);

		for (int i = 0; i < numQuotes; i++)
		{
			String q = quotes[i];
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

		if (topToys > pq.size())
			for (int i = 0; i < numToys && !pq.isEmpty(); i++)
				res.add(pq.poll().word);
		else
			for (int i = 0; i < pq.size(); i++)
				res.add(pq.poll().word);

		return res;
	}
	
}

class Word implements Comparable<Word>{
	public String word;
	public int count;
	public Set<Integer> quoteId;

	public Word(String word, int count, Set<Integer> quoteId) {
		super();
		this.word = word;
		this.count = count;
		this.quoteId = quoteId;
	}

	@Override
	public int compareTo(Word o) {
		int x = Integer.compare(o.count, this.count);
		if(x == 0) {
			int y = Integer.compare(o.quoteId.size(), this.quoteId.size());
			if(y == 0) {
				return this.word.compareTo(o.word);
			}
			return y;
		}
		return x;
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
