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
    int maxAns;
    public void preOrder(TreeNode root,int min,int max){
        if(root == null) return;
        maxAns = Math.max(Math.abs(root.val - min), maxAns);
        maxAns = Math.max(Math.abs(root.val - max), maxAns);

        preOrder(root.left, Math.min(min, root.val), Math.max(max, root.val));
        preOrder(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
    public int maxAncestorDiff(TreeNode root) {
        maxAns = 0;
        preOrder(root, root.val, root.val);
        return maxAns;
    }
}