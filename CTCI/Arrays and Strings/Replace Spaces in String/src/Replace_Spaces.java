
public class Replace_Spaces {
	
	/**
	 * Write a method to replace all spaces in a string with '%20'.
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "he llo   ";
		final int trueLength = 6; // "he llo"
		replaceSpaces(str.toCharArray(), trueLength);
	}
	
	public static void replaceSpaces(char[] str, int length) {
		int numSpaces = 0, newLength;
		
		// figure out how many spaces we have in the string
		for (int i = 0; i < length; ++i) {
			if (str[i] == ' ')
				numSpaces++;
		}
		
		// calculate the new length of the final string keeping the space in mind of the replaced string
		newLength = length + 2 * numSpaces;
		
		// manually add null terminator
		str[newLength] = '\0';
		
		// work from end of string back to front adding in the replaced string for each white space 
		// actual editing of the string
		// start at the char before null terminator, go from end to front (first character) and modify the chars
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength -= 3;
			}
			// no space, so just copy the character into the right spot
			else { 
				str[newLength - 1] = str[i];
				newLength--;
			}
		}
		
		// print the modified string
		for (int i = 0; i < str.length; ++i) {
			System.out.print(str[i]);
		}
	}
}
