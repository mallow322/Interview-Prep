import java.util.Stack;

/**
 * @author joe
 * Problem #155 LeetCode
 * https://oj.leetcode.com/problems/min-stack/
 * Design a stack that can keep track of the min element as well as performing normal operations in O(1) time.
 * 
 * Instead of having two stacks (one for the regular stack and one for the minStack), we can just use one stack
 * and keep track of the gap between the min value and the current value.
 * Note that the possible gap between the current value and the min value could be Integer.MAXVALUE-Integer.MINVALUE;
 *
 */
public class Min_Stack {
	long min;
	Stack<Long> stack;
	
	public Min_Stack() {
		stack = new Stack<>();
	}
	
	public void push(int x) {
        if (stack.isEmpty()) {
        	stack.push(0L);
        	min = x;
        }
        else {
        	stack.push((long) (x-min)); // Could be negative if min value needs to change
        	if (x < min)
        		min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        
        long popped = stack.pop();
        if (popped < 0) 
        	min -= popped; // If it's negative, increase the min value
    }

    public int top() {
    	long top = stack.peek();
    	if (top > 0)
    		return (int)(top+min);
    	else 
    		return (int)(this.min);
    }

    public int getMin() {
		return (int) this.min;
    }
}