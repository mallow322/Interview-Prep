import java.util.HashMap;

public class Repeated_Numbers_Array_Find_Non {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 2, 5, 2, 1};
		System.out.println(find_non_repeated(arr));
	}
	
	public static int find_non_repeated(int[] arr) {
		HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; ++i) {
			int key = new Integer(arr[i]);
			if (occurences.containsKey(key)) {
				occurences.put(key, occurences.get(key) + 1);
			}
			else {
				occurences.put(key, 1);
			}
		}
		
		for (int key : occurences.keySet()) {
			if (occurences.get(key) != 2) {
				return key;
			}
		}
		return -1;
	}

}
