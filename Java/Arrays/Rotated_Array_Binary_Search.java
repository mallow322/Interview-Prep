import java.util.Arrays;

public class Rotated_Array_Binary_Search {

	/**
	 * Perform a binary search on a rotated/shifted array to search for a value.
	 * Ideally, want to perform this in O(log n) time otherwise you could sort and then search in O(N) with linear
	 * time sorting algos and b-search or sort in O(N log N) and then search
	 */
	
	public static void main(String[] args) {
		test_rotated_binary_search();
	}
	
	public static void test_rotated_binary_search() {
		int[] arr = {5, 6, 7, 8, 9, 3, 4};
		int[] arr2 = {6, 5, 4, 2, 3};
		int searchValue = 2;
		System.out.println(rotated_binary_search(arr2, searchValue));
	}
	
	public static int rotated_binary_search(int[] arr, int searchValue) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			// safety to avoid overflow
			int mid = left + (right - left) / 2;
			
			// if found
			if (arr[mid] == searchValue) return mid;
			
			// the bottom half is sorted
			if (arr[left] <= arr[mid]) {
				if (arr[left] <= searchValue && searchValue <= arr[mid])
					right = mid - 1;
				else 
					left = mid + 1;
			}
			// the upper half is sorted
			else {
				if (arr[mid] <= searchValue && searchValue <= arr[right]) 
					left = mid + 1;
				else 
					right = mid - 1;
			}
		}
		
		return -1;
	}
	
	
	public static void test_bsearch_regular() {
		int[] arr = {27, 43, 30, 3, 5, 7, 9, 11};
		Arrays.sort(arr);
		System.out.println(binary_search_regular(arr, 7, 0, arr.length));
	}
	
	/**
	 * NOTE: Array must be sorted!!!
	 * Returns the index of the search element if found, -1 otherwise
	 * @param arr array of ints
	 * @param search int search value
	 * @param low lower end of partition to look at
	 * @param high higher end of partition half to look at
	 */
	public static int binary_search_regular(int[] arr, int search, int low, int high) {
		if (high < low) return -1;
		
		int mid = (high + low) / 2;
		
		// if we found it!
		if (arr[mid] == search) return mid;
		else if (search > arr[mid]) return binary_search_regular(arr, search, mid+1, high);
		else if (search < arr[mid]) return binary_search_regular(arr, search, low, mid-1);
				
		return -1;
	}
}
