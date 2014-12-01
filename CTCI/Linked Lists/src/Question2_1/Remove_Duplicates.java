package Question2_1;

import java.util.HashSet;
import java.util.Hashtable;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Remove_Duplicates {
	/*
	 * O(1) space
	 * O(N^2) time
	 */
	public static void delete_duplicates_noBuffer(LinkedListNode head) {
		if (head == null) return;
		LinkedListNode current = head;
		/**
		 * Current iterates through the linked list.
		 * Runner runs through the subsequent nodes to check for duplicates.
		 */
		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data){
					runner.next = runner.next.next;
				}
				else {
					runner = runner.next;			
				}
			}
			current = current.next;
		}
	}
	
	/*
	 * O(N) Space
	 * O(N) Time
	 */
	public static void delete_duplicatesB(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode prev = null;
		while (n != null) {
			if (set.contains(n.data)) {
				prev.next = n.next;
			}
			else {
				set.add(n.data);
				prev = n;
			}
			n = n.next;
		}
	}
	
	/*
	 * O(N) Space
	 * O(N) Time
	 */
	public static void delete_duplicatesA(LinkedListNode current) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		LinkedListNode seen = null;
		// walk the list
		while (current != null) {
			// if already have an instance of the value in our table, we remove it
			if (table.containsKey(current.data)) {
				seen.next = current.next;
			}
			else {
				table.put(current.data, true);
				seen = current;
			}
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode first = AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 15; i++) {
			second = new LinkedListNode(i % 2, null, null); // node has val of 0 or 1 then
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println("Original list: " + head.printForward());
//		delete_duplicatesA(head);
//		delete_duplicatesB(head);
		delete_duplicates_noBuffer(head);
		System.out.println("After dupe has been called: " + head.printForward());
	}
}

