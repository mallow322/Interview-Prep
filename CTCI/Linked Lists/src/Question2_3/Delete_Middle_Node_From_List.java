package Question2_3;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Delete_Middle_Node_From_List {
	public static boolean delete_middle_node(LinkedListNode middle) {
		if (middle == null || middle.next == null) {
			return false;
		}
		// used as temp Node to hold the middle's data references
		LinkedListNode nextNode = middle.next;
		middle.next = nextNode.next;
		middle.data = nextNode.data;
		return true;
	}
	
	/*
	 * Delete a node in the middle of a singly linked list given only access to that node
	 */
	public static void main(String[] args) {
		int numberNodes = 9;
		LinkedListNode head = AssortedMethods.randomLinkedList(numberNodes, 0, 10);
		System.out.println(head.printForward());
		int middle = (int) Math.floor(numberNodes / 2);
		LinkedListNode current = head;
		for (int i = 0; i < middle; i++) {
			current = current.next;
		}
		if(delete_middle_node(current)) {
			System.out.println("Successfully deleted node");
			System.out.println(head.printForward());
		}
		else {
			System.out.println("Couldn't delete the node.");
		}
	}
}
