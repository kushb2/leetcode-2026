/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode possibleAncestor1 = lowestCommonAncestor(root.left, p, q);
        TreeNode possibleAncestor2 = lowestCommonAncestor(root.right, p, q);

        if(possibleAncestor1 != null && possibleAncestor2 != null) return root;

        return possibleAncestor1 != null ? possibleAncestor1 : possibleAncestor2;

        
    }
}