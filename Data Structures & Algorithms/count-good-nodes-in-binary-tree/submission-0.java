/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int dfs(TreeNode node, int maxsofar){
        int count = 0;

        if (node == null){
            return 0;
        }

        maxsofar = Math.max(maxsofar, node.val);
        if (node.val >= maxsofar){
            count += 1;
        }

        dfs(node.left, maxsofar);
        dfs(node.right, maxsofar);

        return count + dfs(node.left, maxsofar) + dfs(node.right, maxsofar);
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
}
