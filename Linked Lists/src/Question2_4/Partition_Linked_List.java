package Question2_4;

import CtCILibrary.LinkedListNode;

public class Partition_Linked_List {

	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {1, 12, 5, 7, 2, 3, 9};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		// Partition a linked list around a particular value
		LinkedListNode node = partition(head, 5);
		
		// Print the resulting (partitioned) list
		System.out.println(node.printForward());
	}

	private static LinkedListNode partition(LinkedListNode node, int x) {
		// One list
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		// Another list
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			
			if (node.data < x) {
				// insert the node into the back of the list
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else {
				// insert the node into the back of the list
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				}
				else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		
		// if the before list is empty, can just return the after list--no need to merge
		if (beforeStart == null) {
			return afterStart;
		}
		
		// merge before list and after list
		beforeEnd.next = afterStart;
		return beforeStart;
	}
}
