
public class Run_Length_Encode {

	public static void main(String[] args) {
		String input = "hhelleooab";
		System.out.println(compress(input));
	}
	
	public static String compress(String str) {
		if (str.isEmpty()) return "";
		
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		
		int count = 1;
		char prev = chars[0];
		char current = ' ';
		
		for (int i = 1; i < chars.length; ++i) {
			current = chars[i];
			if (current == prev) ++count;
			else {
				sb.append(count).append(prev);
				count = 1;
			}
			prev = current;
		}
		
		// Have to append the last letter and count (know it will be just one letter at this time due to the loop invariant)
		return sb.append(count).append(current).toString();
	}

}
