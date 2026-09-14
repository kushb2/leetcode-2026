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
    int ans = 0;

    public int solve(TreeNode root){
        if(root == null) return 0;

        int leftSubTreeLen = solve(root.left);
        int rightSubTreeLen = solve(root.right);

        ans = Math.max(ans, leftSubTreeLen + rightSubTreeLen);
        return Math.max(leftSubTreeLen, rightSubTreeLen) + 1;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return ans;
        
    }
}