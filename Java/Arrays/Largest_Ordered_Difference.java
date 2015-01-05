import java.util.Arrays;
import java.util.Random;


public class Largest_Ordered_Difference {

	/**
	 * Calculate the maximum difference between two elements such that the larger element appears after the smaller number.
	 */
	public static void main(String[] args) {
		Random random = new Random();
		int size = 10;
		int arr[] = new int[size];
		for (int i = 0; i < size; ++i) {
			arr[i] = random.nextInt(25);
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println("The maximum difference is: " + maxDiff(arr));
	}
	
	/**
	 * O(N) time
	 * O(1) space
	 */
	public static int maxDiff(int arr[]) {
		int length = arr.length;
		if (length < 2) return arr[0];
		int max_diff = arr[1] - arr[0]; // max difference found so far
		int min_so_far = arr[0]; // min number visited so far
		
		for (int i = 0; i < length; ++i) {
			if (arr[i] - min_so_far > max_diff)
				max_diff = arr[i] - min_so_far;
			if (arr[i] < min_so_far)
				min_so_far = arr[i];
		}
		return max_diff;
	}

}
