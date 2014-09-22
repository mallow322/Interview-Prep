
public class Replace_Spaces {
	
	/**
	 * Write a method to replace all spaces in a string with '%20'.
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "he llo   ";
		final int trueLength = 5;
		System.out.println("The new string is " + replaceSpaces(str.toCharArray(), trueLength));

	}
	
	public static String replaceSpaces(char[] str, int length) {
		int numSpaces = 0, newLength;
		
		for (int i = 0; i < length; ++i) {
			if (str[i] == ' ')
				numSpaces++;
		}
		
		// calculate the new length keeping the space in mind of the replaced string
		newLength = length + 2 * numSpaces;
		
		// manually add null terminator
		str[newLength] = '\0';
		
		// work from end of string back to front adding in the replaced string for each white space 
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength -= 3;
			}
			else {
				str[newLength - 1] = str[i];
				newLength -= 1;
			}
		}
		return str.toString();
	}
}
