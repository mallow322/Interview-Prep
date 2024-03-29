
/**
 * 
 * @author Joe 
 * @date 8/31/14
 *
 */

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String example_string = "test";
		System.out.println(IsUniqueChars(example_string));
	}
	
	/*
	 *  Assumption: ASCII string
	 *  Time complexity: O(N)
	 *  Space complexity: O(1)
	 */
	public static boolean IsUniqueChars(String str) {
		final int ASCII_EXTENDED_SET_SIZE = 256;
		if (str.length() > ASCII_EXTENDED_SET_SIZE) {
			return false;
		}
		
		boolean[] char_set = new boolean[ASCII_EXTENDED_SET_SIZE];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			// if already found char in our set
			if (char_set[val]) {
				return false;
			}
			// otherwise, add it to our set now
			char_set[val] = true;
		}
		return true;
	}
	
	

}
