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
    int maxSum;
    public int postOrder(TreeNode root){
        if(root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int sum = root.val;
        if(left > 0){
            sum += left;
        }
        if(right > 0){
            sum += right;
        }

        maxSum = Math.max(maxSum, sum);

        if(sum == root.val){
            return sum;
        }else if(left > right){
            return root.val + left;
        }else{
            return root.val + right;
        }

    }
    public int maxPathSum(TreeNode root) {
        this.maxSum = -100000;
        postOrder(root);
        return maxSum;

        
    }
}