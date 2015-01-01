/**
 * Balanced Binary Tree
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 * LeetCode Problem #110
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
