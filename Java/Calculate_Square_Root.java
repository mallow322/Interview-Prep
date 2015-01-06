/**
 * @author joe
 * Calculate the square root of a number.
 */
public class Calculate_Square_Root {

	public static void main(String[] args) {
		double num = 21.2;
		
		double myRes = calc_sqrt(num);
		double actual = Math.sqrt(num);
		System.out.println("My result: " + myRes);
		System.out.println("Actual: " + actual);
		System.out.println("The difference is " + (actual - myRes));
	}
	
	public static double calc_sqrt(double num) {
		double acceptableError = 0.00001;
		double low = 0, high = num, mid = num;
		double oldMid = -1;
		
		while (Math.abs(oldMid - mid) >= acceptableError) {
			// Save the old middle for the comparison to the error (i.e. diffs between iterations)
			oldMid = mid;
			
			mid = (high + low) / 2;
			double midSq = mid * mid;
			
			// Decide where to update the mid
			if (midSq > num)
				high = mid;
			else 
				low = mid;
		}
		return mid;
	}

}
