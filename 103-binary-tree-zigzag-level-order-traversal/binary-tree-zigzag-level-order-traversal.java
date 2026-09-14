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
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            TreeNode curr = q.poll();
            if(leftToRight) {
                list.addLast(curr.val);
            }else{
                list.addFirst(curr.val);
            }
            

            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
            
        }
        
        leftToRight = !leftToRight;
        ans.add(list); 
        

       }
       return ans;

        
    }
    //  15 7 
    // 3 20 9 15 7 
}