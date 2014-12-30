package Question9_1;

/**
 * A child can hop 1, 2, or 3 steps. Determine the total number of possibilites for the steps given a total number of steps to travel.
 * This question is from Chapter 9, Question 1 of Cracking the Coding Interview (Edition 5).
 */
public class Children_Steps {

	public static void main(String[] args) {
		int n = 5;
		int[] possibilities = new int[n+1];
		for (int i = 0; i < possibilities.length; ++i) possibilities[i] = -1;
		long result = count_number_steps(n, possibilities);
		System.out.println(result);
	}
	
	public static long count_number_steps(int n, int[] possibilities) {
		if (n < 0) return 0;
		else if (n == 0) return 1;
		else if (possibilities[n] > -1) return possibilities[n];
		else {
			possibilities[n] = (int) (count_number_steps(n-1, possibilities) + count_number_steps(n-2, possibilities) + 
				+ count_number_steps(n-3, possibilities));
			return possibilities[n];
		}
	}

}
