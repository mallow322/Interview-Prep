/**
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * LeetCode Problem #160
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
    * 1. Get the length of the two lists.
    * 2. Align them to the same start point.
    * 3. Move them together until finding the intersection point, or the end null
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
