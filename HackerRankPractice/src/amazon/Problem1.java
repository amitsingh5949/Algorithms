package amazon;




import java.util.List;
import java.util.*;


public class Problem1
{        

	public static void main(String[] args) {

	}
	List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude){
		
		if(literatureText == null){
			return new ArrayList<String>();
		}
		if(literatureText == ""){
			return new ArrayList<String>();
		}  
		
		String[] literatureTexts = literatureText.split("\\W");
		
		Map<String, Integer> words = new HashMap<>();
		
		Set<String> wordsExcluded = new HashSet<>();
		wordsExcluded.addAll(wordsToExclude);
		
		List<String> result = new ArrayList<String>();
		int countMax = 0;
		
		for(String s : literatureTexts){
			if(wordsExcluded.contains(s) || s.equals("")){
				continue;
			}
			s = s.toLowerCase();
			words.put(s,words.getOrDefault(s,0)+1);
			countMax = Math.max(countMax,words.get(s));
		}
		for(String s: words.keySet()){
			if(words.get(s) == countMax) {
				result.add(s);
			}
		}
		return result;
	}
}
