import java.util.Arrays;


public class Permutation {

	/**
	 * Given two strings, determine if one is a permutation of the other.
	 */
	public static void main(String[] args) {
		// test cases for comparing two strings
		String str1 = "hello";
		String str2 = "elhol";
		
		if (isPermutation(str1, str2)) {
			System.out.println("The strings " + str1 + " and " + str2 + " are permutations of one another.");
		}
		else {
			System.out.println("The strings " + str1 + " and " + str2 + " are NOT permutations of one another.");
		}
	}
	
	/**
	 * Checks to see if two strings are permutations of one another in O(n*log n) time.
	 * @param str1 first string
	 * @param str2 second string
	 * @return true if one string is a permutation of the other
	 */
	public static boolean isPermutation(String str1, String str2) {
		// sort the strings
		// if the sorted strings match up, they are permutations of one another
		if (str1.length() != str2.length()) {
			return false;
		}
		
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		
		// sort the char arrays (takes O(n log n) time)
		Arrays.sort(a);
		Arrays.sort(b);
		
		// could also use Array.equals, but that kind of defeats the purpose of this problem
		for (int i = 0; i < a.length; ++i) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		
		return true;
	}
}
