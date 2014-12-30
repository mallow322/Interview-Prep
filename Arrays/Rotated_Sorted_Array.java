
public class Rotated_Sorted_Array {
	
    /**
     * Searches for the value provided in the rotated sorted array.
     * If found, returns the index, of provided array, else returns -1.
     * If array is not rotated and sorted, then results are unpredictable
     *
     * Throws an exception if array is null.
     *
     * @param a the rotated sorted array
     * @param x the element to be searched
     * @returns the index at which the element is found, else returns -1
     */
    public static int binarySearchForRotatedArray(int[] a, int x) {
        int partitionIndex = findPartition(a);

        if (partitionIndex == -1) return -1;
        
        // goal is to find the element in the array who is smaller than the 0th element in array
        // i.e. where the shift point is
        if (x >= a[0] && x <= a[partitionIndex]) {
            return binarySearch(a, 0, partitionIndex, x);
        } else {
            return binarySearch(a, partitionIndex + 1, a.length -1, x);
        }

    }

    private static int binarySearch (int[] a, int lb, int hb, int x) {
        assert a != null;

        while (lb <= hb)
        {
            int mid = (lb + hb)/2;
            int midv = a[mid];
            if (midv < x) {
                lb = mid + 1;
            } else if (midv > x) {
                hb = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Returns the index of greatest element of the rotated sorted array.
     * if array is not rotated sorted, results are unpredictable
     *
     * @param a     the input array
     * @return      the index of the highest element in the array.
     */
    private static int findPartition(int[] a) {
        assert a!= null;

        int lb = 0;
        int hb = a.length-1;

        // Check if rotation is 0
        if (a[lb] < a[hb])
            return hb;

        while (lb != hb)
        {
            int mid = (lb + hb)/2;

            if (a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[mid] > a[hb]) {
                // go right.
                lb = mid + 1;
            } else {
                // go left.
                hb = mid; // note i cannot do mid - 1
            }
        }
        return -1;
    }
	
	
	public static void main(String[] args) {
		 // even length of the array.
        int expected = 0; int actual = 0;
        int[] a1 = {6, 7, 8, 1, 2, 3};
        expected = -1; actual = binarySearchForRotatedArray(a1, -1);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        int[] a2 = {6, 7, 8, 1, 2, 3};
        expected = 1; actual = binarySearchForRotatedArray(a2, 7);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        int[] a3 = {6, 7, 8, 1, 2, 3};
        expected = 5; actual = binarySearchForRotatedArray(a3, 3);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        int[] a4 = {6, 7, 8, 1, 2, 3};
        expected = 2; actual = binarySearchForRotatedArray(a4, 8);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        int[] a5 = {6, 7, 8, 1, 2, 3};
        expected = 3; actual = binarySearchForRotatedArray(a5, 1);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);

        // odd length of the array.
        int[] a6 = {4, 6, 7, 8, 1, 2, 3};
        expected = -1; actual = binarySearchForRotatedArray(a6, -1);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        int[] a7 = {4, 6, 7, 8, 1, 2, 3};
        expected = 2; actual = binarySearchForRotatedArray(a7, 7);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        int[] a8 = {4, 6, 7, 8, 1, 2, 3};
        expected = 6; actual = binarySearchForRotatedArray(a8, 3);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        int[] a9 = {4, 6, 7, 8, 1, 2, 3};
        expected = 3; actual = binarySearchForRotatedArray(a9, 8);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        int[] a10 = {4, 6, 7, 8, 1, 2, 3};
        expected = 4; actual = binarySearchForRotatedArray(a10, 1);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);

        // properly sorted
        int[] a11 = {1, 2, 3, 4, 5, 6, 7};
        expected = -1; actual = binarySearchForRotatedArray(a11, 0);
        expected = 0;  actual = binarySearchForRotatedArray(a11, 1);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        expected = 1;  actual = binarySearchForRotatedArray(a11, 2);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        expected = 2;  actual = binarySearchForRotatedArray(a11, 3);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        expected = 3;  actual = binarySearchForRotatedArray(a11, 4);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        expected = 4;  actual = binarySearchForRotatedArray(a11, 5);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        expected = 5;  actual = binarySearchForRotatedArray(a11, 6);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        expected = 6;  actual = binarySearchForRotatedArray(a11, 7);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
        expected = -1; actual = binarySearchForRotatedArray(a11, 8);
        if (expected != actual) System.out.println("Expected " + expected + " , Actual : " + actual);
	}

}
