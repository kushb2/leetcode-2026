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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
       Queue<TreeNode> q = new ArrayDeque<>();
       q.add(root);
        boolean leftToRight = true;
       while(!q.isEmpty()){
        int n = q.size();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            TreeNode curr = q.poll();
            list.add(curr.val);

            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        if(!leftToRight) {
            Collections.reverse(list);
        }
        leftToRight = !leftToRight;
        ans.add(list); 
        

       }
       return ans;

        
    }
}