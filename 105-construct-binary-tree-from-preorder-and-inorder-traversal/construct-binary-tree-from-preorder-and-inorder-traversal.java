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
    int i,j;
    public int findIndex(int[] inorder, int target, int start,int end){
        for(int i=start;i<=end;i++){
            if(target == inorder[i]) return i;

        }
        return -1;
    }
    TreeNode construct(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        int rootIndex = findIndex(inorder, preorder[i], start, end);
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = construct(preorder, inorder, start, rootIndex-1);
        root.right = construct(preorder, inorder, rootIndex+1, end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.i = 0;
        return construct(preorder,inorder, 0, inorder.length-1);
    }
}