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
    boolean valid;

    public int postOrder(TreeNode root){
        if(root == null || !valid) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        if(Math.abs(left-right) > 1) {
            valid = false;
        }

        return Math.max(left, right)+1;
    }

    public boolean isBalanced(TreeNode root) {
        this.valid = true;
        postOrder(root);
        return valid;
        
    }
}