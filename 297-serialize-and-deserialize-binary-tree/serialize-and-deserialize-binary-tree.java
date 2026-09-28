/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public void preOrder(TreeNode root, StringBuilder s){
        if(root == null){
            s.append("#,");
            return;
        }
        s.append(Integer.toString(root.val));
        s.append(",");
        preOrder(root.left, s);
        preOrder(root.right, s);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder s = new StringBuilder();
        preOrder(root, s);
        return new String(s);
        
    }

    // Decodes your encoded data to tree.
    int index;
    public TreeNode construct(String[] data, int size){
        if(index == size) return null;
        if(data[index].equals("#")){
            index++;
            return null;
        } 
        TreeNode root = new TreeNode(Integer.parseInt(data[index]));
        index++;

        root.left = construct(data, size);
        root.right = construct(data, size);
        return root;
    }
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if(data.isEmpty()) return null;
        index = 0;
        String[] arr = data.split(",");

        return construct(arr, arr.length);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));