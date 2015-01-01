/**
 * https://oj.leetcode.com/problems/path-sum/
 * LeetCode Path Sum problem #112
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        
        if (root.left == null && root.right == null && sum - root.val == 0)
            return true;
    
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
