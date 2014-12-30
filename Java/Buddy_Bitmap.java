import java.util.Arrays;

/* Pure storage buddy system bitmap
    Given a complete binary tree with nodes of values of either 1 or 0, the following rules always hold:
    (1) a node's value is 1 if and only if all its subtree nodes' values are 1
    (2) a leaf node can have value either 1 or 0
    Implement the following 2 APIs:
    set_bit(offset, length), set the bits at range from offset to offset+length-1
    clear_bit(offset, length), clear the bits at range from offset to offset+length-1
    
    i.e. The tree is like:
                 0
              /     \
             0        1
           /  \      /  \
          1    0    1    1
         /\   / \   / 
        1  1 1   0 1
        Since it's complete binary tree, the nodes can be stored in an array:
        [0,0,1,1,0,1,1,1,1,1,0,1]       
*/

public class Buddy_Bitmap {
	/*
	* Helper function to help recurse down the tree when setting bits
	 */
	public static void set_bit_down(int A[], int x, int n) {
		if (x >= n) return;
		// left child
		if (2*x+1 <= n && A[2*x+1] == 0) {
			A[2*x+1] = 1;
			set_bit_down(A, 2*x+1, n);
		}
		// right child
		if (2*x+2 <= n && A[2*x+2] == 0) {
			A[2*x+2] = 1;
			set_bit_down(A, 2*x+2, n);
		}
	}

	public static void set_bit(int A[], int pos, int length) {
	    // not valid, so don't continue
	    if (A == null || pos <= 0 || length <= 0) return;

	    int n = length - 1; // last index
	    
	    for (int x = pos; x < Math.min(n + 1, Math.min(pos + length, 2 * pos + 1)); ++x) {
	    	// A[x] = 1;
	    	// set the descendants
	    	set_bit_down(A, x, n);
	    	
	    	// set the ancestors
	    	while (x > 0) {
	    		if ( (x%2 == 0 && A[x-1] == 1) || (x%2==1 && x < n && A[x+1] == 1) ) {
	    			A[(x-1) / 2] = 1;
	    		}
	    		x = (x-1) / 2;
	    	}
	    }
	}

	public static void clear_bit(int A[], int pos, int length) {
		if (A == null || pos <= 0 || length <= 0) return;
		int n = length - 1;
		
		for (int x = pos; x < Math.min(n + 1, pos + length); ++x) {
//			A[x] = 0;
			// Clear the descendants
			while (2*x+1 <= n) {
				A[2*x+1] = 0;
				x = 2*x+1;
			}
			
			// Clear the ancestors
			while (x > 0) {
				if (A[2*x-1] == 0) break;
				A[(x-1)/2] = 0;
				x = (x-1)/2;
			}
		}
	}
	
}
