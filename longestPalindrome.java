import java.util.HashMap;
import java.util.Map;

public class longestPalindrome {
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String longestPal(String str) {
		Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
		StringBuilder newStr = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			if(dictionary.containsKey(str.charAt(i))) {
				int holder = dictionary.get(str.charAt(i));
				dictionary.put(str.charAt(i), holder + 1);
			} else {
				dictionary.put(str.charAt(i), 1);
			}
		}
		char oddChar = ' ';
		
		
		for(int i = 0; i < str.length(); i++) {
			if(dictionary.get(str.charAt(i)) % 2 == 0) {
				int count = dictionary.get(str.charAt(i));
				while(count > 1) {
					newStr.append(str.charAt(i));
					count--;
				}
				dictionary.put(str.charAt(i), count);
			} else {
				oddChar = str.charAt(i);
			}
		}
			
			if(oddChar != ' ') {
				newStr.append(oddChar);
			}
			
//			newStr = newStr.append(newStr.reverse());

	return newStr.toString() + newStr.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(longestPal("abcac"));
	}
	
}
