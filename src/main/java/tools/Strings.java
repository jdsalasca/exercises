package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Strings {
	public int leghtOfLastWord(String word) {
		String[] listOfWords = word.split(" ");
		return listOfWords[listOfWords.length - 1].length();
	}

	public char findTheDifference(String s, String t) {
		char[] sC = s.toCharArray();
		char[] tC = t.toCharArray();
		Arrays.sort(sC);
		Arrays.sort(tC);
		for (int i = 0; i < tC.length; i++) {
			if (i > s.length() - 1) {
				return tC[i];
			}
			if (sC[i] != tC[i]) {
				return tC[i];
			}
		}
		return 0;
	}
	

	
	public int lengthOfLongestSubstring(String s) {
		int longest = 0;
		List<Integer> temp = new ArrayList<>();
		for (char letter : s.toCharArray()) {
			int letterI =  letter;
			if (!temp.contains(letterI)) {
				temp.add(letterI);
			} else {
				longest = Math.max(temp.size(), longest);
				while (temp.contains(letterI)) {
					temp.remove(0);
				}
				temp.add(letterI);
			}
		}
		longest = Math.max(temp.size(), longest);
		return longest;
	}
	
	

	public char findTheDifferenceII(String s, String t) {
		int result = 0;
		int i;

		for (i = 0; i < t.length() - 1; i++) {
			result += t.charAt(i) - s.charAt(i);
		}
		result += t.charAt(i);
		return (char) result;
	}

	/**
	 * This algorithm instead of order string 1 and string t, try to convert them to
	 * bytes
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public char findTheDifferenceIII(String s, String t) {
		int result1 = 0;

		int result2 = 0;
		for (int i = 0; i < s.length(); i++) {
			result1 += s.charAt(i);
		}
		for (int i = 0; i < t.length(); i++) {
			result2 += t.charAt(i);
		}
		return (char) ((char) result2 - result1);
	}

	/**
	 * this was my answers not a bad answer c:
	 * 
	 * @param haystack
	 * @apiNote this method uses something similar to the Sliding windows
	 * @param needle
	 * @returns
	 */
	public int strStr(String haystack, String needle) {
		char[] word = haystack.toCharArray();
		char[] needleC = needle.toCharArray();
//		if (word.length < needleC.length) {
//			return -1;
//		}
		for (int i = 0; i <= (word.length - needleC.length); i++) {

			if (word[i] == needleC[0]) {
				int j;
				for (j = 0; j < needleC.length; j++) {
					if (word[i + j] != needleC[j]) {
						break;
					}

				}
				if (j == needleC.length) {
					return i;
				}
			}
		}

		return -1;
	}
	/**
	 * The is an approach that uses sliding windows approach joined with hash
	 * algorithms
	 */

}
