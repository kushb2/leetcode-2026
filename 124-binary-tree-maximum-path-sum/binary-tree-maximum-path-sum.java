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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
    public int solve(TreeNode root){
        if(root == null) return 0;
        // if(root.left == null && root.right == null) return root.val;

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        leftSum = leftSum < 0 ? 0 : leftSum;
        rightSum = rightSum < 0 ? 0 : rightSum;

        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return  Math.max(leftSum, rightSum) + root.val;
    }
}