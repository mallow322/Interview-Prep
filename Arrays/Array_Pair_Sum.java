import java.util.HashMap;


public class Array_Pair_Sum {

	/**
	 * Find pairs of numbers in a given int array whose sum is k.
	 */
	public static void main(String[] args) {
		int[] arr = {2, 45, 7, 3, 5, 1, 8, 10, 9};
		final int sum_value = 10;
		make_pairs(arr, sum_value);
	}
	
	public static void make_pairs(int[] arr, int k) {
		HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; ++i) {
			if (pairs.containsKey(arr[i])) {
				System.out.println(arr[i] + ", " + pairs.get(arr[i]));
			}
			else {
				// put complement (k-value in arr) as key, actual val in arr as value in HashMap
				pairs.put(k-arr[i], arr[i]);
			}
		}
	}	
	
}
