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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i<size; i++){
                TreeNode val = queue.poll();
                if (i == size - 1){
                    result.add(val.val);
                }

                if (val.left != null){
                    queue.add(val.left);
                }

                if (val.right!= null){
                    queue.add(val.right);
                }
                
            }
        }

        return result;

    }
}
