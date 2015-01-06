import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;


/**
 * @author joe
 * Given two arrays of the same size filled with positive integers 0 <= N <= 255, determine
 * whether N can be written as the sum of some number from the first array and another number
 * from the second array.
 */

public class Two_Array_Target {
	
	public static void main(String[] args) {
		Random random = new Random();
		int len = 25;
		int arr1[] = new int[len];
		int arr2[] = new int[len];
		for (int i = 0; i < len; ++i) {
			arr1[i] = random.nextInt(255);
			arr2[i] = random.nextInt(255);
		}
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		int target = 23;
		HashSet<Point> results = searchTarget(arr1, arr2, target);
		if (results.isEmpty())
			System.out.println("No pairs summing up to " + target);
		else {
			for (Point p : results)
				System.out.println("(" + p.x + "," + p.y + ")");
		}
	}
	
	public static HashSet<Point> searchTarget(int[] a, int[] b, int targetSum) {
		/**
		 * Create a set of the numbers in arr1
		*/
		HashSet<Integer> set = new HashSet<Integer>(a.length);
		for (int i = 0; i < a.length; ++i) 
			set.add(a[i]);
		
		// Create set of result pairs
		HashSet<Point> pairs = new HashSet<Point>();
		
		// Run through arr2 and check if diff is in the set
		for (int j = 0; j < b.length; ++j) {
			int diff = targetSum - b[j];
			if (set.contains(diff))
				pairs.add(new Point(b[j], diff));
		}
		
		return pairs;
	}

}
