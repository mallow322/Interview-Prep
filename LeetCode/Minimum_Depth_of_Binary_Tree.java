/**
 * Problem #111
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        TreeNode endOfLevel = root;
        int depth = 1; // have at least a root, so start at 1 level
        
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left == null && current.right == null) return depth;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            if (current == endOfLevel) {
                endOfLevel = current.right == null ? current.left : current.right;
                depth++;
            }
        }
        return depth;
    }
}
