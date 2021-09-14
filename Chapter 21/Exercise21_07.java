import java.util.*;

public class Exercise21_07 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();

		ArrayList<WordOccurence> list = new ArrayList<WordOccurence>();
		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		for(Map.Entry<String, Integer> i: map.entrySet()) {
			list.add(new WordOccurence(i.getKey(), i.getValue()));
		}
		Collections.sort(list);
		list.forEach(occurence -> {
				System.out.println(occurence.getWord() + "\t" + occurence.getCount());
		});
	}
}

class WordOccurence implements Comparable<WordOccurence> {
	String word = "blank";
	int count = 0;
	WordOccurence(String newWord, int newCount){
		word = newWord;
		count = newCount;
	} 
	@Override
	public int compareTo(WordOccurence element) {
		if(element.getCount() > count) {
			return 1;
		}
		else if(element.getCount() == count){
			return 0;
		}
		else {
			return -1;
		}
	}
	String getWord() {
		return word;
	}
	int getCount() {
		return count;
	}
}