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
    int ans;
    public int postOrder(TreeNode root){
        if(root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);
        ans = Math.max(left+right, ans);
        return Math.max(left, right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        postOrder(root);
        return ans;
        
    }
}