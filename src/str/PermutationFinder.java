/**
 * 
 */
package str;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author amishra
 *
 */
public class PermutationFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> charCountForPattern = new HashMap<>();
		Map<Character, Integer> charCountForText  = new HashMap<>();
		
		charCountForPattern.put('a', 1);
		charCountForPattern.put('a', 1);
		charCountForText.put('a', 2);
		System.out.println(new PermutationFinder().find("cbabadcbbabbcbabaabccbabc", "abbc"));
	}

	private List<Integer> find(String text, String pattern) {
		List<Integer> indexes = new LinkedList<>();
		Map<Character, Integer> charCountForPattern = new HashMap<>();
		Map<Character, Integer> charCountForText  = new HashMap<>();
		
		// Count the distinct characters from pattern 
		for (int indx = 0; indx < pattern.length(); indx++)
			countByCharacter(pattern.charAt(indx), charCountForPattern);
		// Count the distinct characters from first window of text having equal length of pattern
		for (int indx = 0; indx < pattern.length(); indx++)
			countByCharacter(text.charAt(indx), charCountForText);
		
		// Start traversing the remaining text
		for (int indx = pattern.length(); indx < text.length(); indx++) {

			// Compare both the map and if matches add starting indx into the list
			if (charCountForPattern.equals(charCountForText))
				indexes.add(indx - pattern.length());

//			if (!charCountForPattern.containsKey(text.charAt(indx))) {
//				indx += pattern.length() - 1;
//				continue;
//			}

			// Sliding window - reduce last character count
			if (charCountForText.containsKey(text.charAt(indx - pattern.length())) && 
					charCountForText.get(text.charAt(indx - pattern.length())) > 1) {

				charCountForText.put(text.charAt(indx - pattern.length()),
						charCountForText.get(text.charAt(indx - pattern.length())) - 1);
			} else
				charCountForText.remove(text.charAt(indx - pattern.length()));
			
			// Sliding window - increase new character count
			countByCharacter(text.charAt(indx), charCountForText);
		}
		
		// Compare for the last sliding window
		if (charCountForPattern.equals(charCountForText))
			indexes.add(text.length() - pattern.length());

		return indexes;
	}
	
	private void countByCharacter(Character ch, Map<Character, Integer> countMap) {
		if (countMap.containsKey(ch))
			countMap.put(ch, countMap.get(ch) + 1);
		else
			countMap.put(ch, 1);
	}

}
