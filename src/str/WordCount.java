/**
 * 
 */
package str;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Used Map to store the appearnces of every word in a given string, sorted by
 * descending order of number of appearances
 *
 * @author amishra
 *
 */
public class WordCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count("It was the best of times, it was the worst of times."));
	}

	private static Map<String, Integer> count(String str) {
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
		
		StringTokenizer stringTokenizer = new StringTokenizer(str, "[!., ]");
		while (stringTokenizer.hasMoreTokens()) {
			String token = stringTokenizer.nextToken().toLowerCase();
			if (wordCountMap.containsKey(token))
				wordCountMap.put(token, wordCountMap.get(token) + 1);
			else
				wordCountMap.put(token, 1);
		}
		return sortByValues(wordCountMap);
	}
	
	private static Map<String, Integer> sortByValues(Map<String, Integer> wordCountMap) {
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		List<Map.Entry<String, Integer>> list = new LinkedList<>(wordCountMap.entrySet());
		Comparator<Map.Entry<String, Integer>> comparator = Comparator
				.comparing(Map.Entry<String, Integer>::getValue).reversed()
				.thenComparing(Map.Entry<String, Integer>::getKey);
		Collections.sort(list, comparator);
		list.stream().forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
		return sortedMap;
	}
}
