package spyhealth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpryCountWordsInQuotations {

	public static void main(String[] args) {

		String fileName = "";

		if(args.length ==  0) {
			System.out.println("Please provide File path. ");
		}
		else if(args.length >=1) {
			fileName = args[0];
			SpryCountWordsInQuotations obj = new SpryCountWordsInQuotations();
			obj.spryCountWordsInQuotations(fileName);
		}
	}


	public void spryCountWordsInQuotations(String fileName) {

		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		Map<String, Word> map = new HashMap<>();

		try {
			File file = new File(fileName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String fileContent = "";
			while((line = br.readLine()) != null){
				fileContent += (line+" ");
			}
			
			fileContent = fileContent.replaceAll("\u201C", "\"").replaceAll("\u201D", "\"");

			Pattern p = Pattern.compile("\"([^\"]*)\"");
			Matcher m = p.matcher(fileContent);
			int i =0;
			while (m.find()) {
				performProcessing(m.group(1),map,i);
				i++;
			}
			printResult(map);
			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file : ( "+ fileName + " ) that you are trying to access does not exist");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void performProcessing(String line, Map<String, Word> map, int occurence){

		line = line.replaceAll("[\\!?,;.]", "").toLowerCase();

		String[] words = line.split(" ");

		for(int i = 0; i<words.length; i++) {
			String word = words[i];
			if(!word.matches(".*\\d.*")) {

				if(!map.containsKey(word)) {
					Word w = map.getOrDefault(word, new Word(word,1,occurence,i));
					map.put(word, w);
				}
				else {
					Word w = map.get(word);
					w.count = w.count +1;
					map.put(word, w);
				}
			}
		}
	}

	public void printResult(Map<String, Word> map) {
		Collection<Word> values = map.values();
		List<Word> list = new ArrayList<>(values);
		Collections.sort(list);
		for(Word word : list) {
			System.out.println(word.word + " " + word.count);
		}
	}
}

class Word implements Comparable<Word>{

	String word;
	int count;
	int lineNumber = 0;
	int firstOccurenceinline = 0;

	public Word(String word, int count, int lineNumber, int firstOccurenceinline) {
		super();
		this.word = word;
		this.count = count;
		this.lineNumber = lineNumber;
		this.firstOccurenceinline = firstOccurenceinline;
	}

	@Override
	public int compareTo(Word o) {
		int count  = Integer.compare(o.count, this.count);
		if(count == 0) {
			count  = Integer.compare(this.lineNumber, o.lineNumber);
			if(count  == 0) {
				count  = Integer.compare(this.firstOccurenceinline, o.firstOccurenceinline);
			}
		}
		return count;
	}

}
