import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


public class BalancedParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String testStr = "{()}[()]";
		boolean result = isValid(testStr);
		System.out.println(result);
	}
	
	public static boolean isValid(String str) {
		HashSet<Character> set = new HashSet<Character>();
		set.add('(');
		set.add('[');
		set.add('{');
		
		// maps a right operator to its friend the left operand which completes it
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		
		// get rid of spaces in the string
		str = str.replaceAll("\\s", "");
		Stack<Character> stack = new Stack<Character>();
		
		// walk through the string one index at a time
		for (int i = 0; i < str.length(); ++i) {
			// if the char is a left operand, push it onto the stack
			if (set.contains(str.charAt(i)))
				stack.push(str.charAt(i));
			// otherwise, it's a right operator, so let's check the stack to see if there's a left one already to match it up
			else {
				if (stack.empty()) return false;
				char c = stack.pop();
				if (map.get(str.charAt(i)) != c) return false;
			}
		}
		return stack.empty(); // returns true if was able to extract everything off the stack otherwise it is incomplete => unbalanced
	}
}
