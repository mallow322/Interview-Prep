import java.util.Arrays;


public class Merge_Two_Sorted_Arrays {

	public static void main(String[] args) {
		int arr1[] = {1, 3, 5, 7};
		int arr2[] = {2, 4, 6};
		int res[] = merge(arr1, arr2);
		System.out.println(Arrays.toString(res));
	}

	
	public static int[] merge(int[] a, int[] b) {
	    int[] answer = new int[a.length + b.length];
	    int i = 0, j = 0, k = 0;
	    
	    while (i < a.length && j < b.length)
	    {
	        if (a[i] < b[j])       
	            answer[k++] = a[i++];
	        else        
	            answer[k++] = b[j++];               
	    }

	    while (i < a.length)  
	        answer[k++] = a[i++];

	    while (j < b.length)    
	        answer[k++] = b[j++];

	    return answer;
	}
}
