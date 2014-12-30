package Question2_2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Kth_To_Last_Element {
	
	/*
	 * O(1) space
	 * O(N) time because traverse list to figure out the number of nodes and then go
	 * through up until length-k and stop
	 */
	public static LinkedListNode nth_to_last_iterative(LinkedListNode head, int k) {
		if (k <= 0) return null;
		if (head == null) return null;
		
		int numNodes = 0;
		LinkedListNode p1 = head;
		while (p1 != null) {
			++numNodes;
			p1 = p1.next;
		}
		
		// reset p1
		p1 = head;
		
		for (int i = 0; i < numNodes - k; i++) {
			p1 = p1.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth = 3;
		LinkedListNode n = nth_to_last_iterative(head, nth);
		
		if (n != null) {
			System.out.println(nth + "th to last node is " + n.data);
		}
		else {
			System.out.println("Null. Something went wrong or N is out of bounds.");
		}
	}

}
