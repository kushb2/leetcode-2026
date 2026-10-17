
 class TrieNode {
       Map<Character, TrieNode> children = new HashMap<>();
       String word = null;
    }

class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length, m = board[0].length;
        TrieNode root = new TrieNode();

        for(String word: words){
            TrieNode node = root;

            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(!node.children.containsKey(c)){
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                }
                node = node.children.get(c);
                
            }
            node.word = word;
        }
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(i,j, n, m , board, root, ans);
            }
        }
        return ans;
    }


    public void dfs(int i, int j, int n, int m , char[][] board, TrieNode root, List<String> ans){
       
       if(!isValid(i, j, n, m, board, root)){
        return;
       }

      

       TrieNode node = root.children.get(board[i][j]); 
        if(node.word != null){
            ans.add(node.word);
            node.word = null;
        }
       char c = board[i][j];
       board[i][j] = '*';
       for(int[] it: dir){
        dfs(i + it[0], j + it[1], n, m, board, node, ans);
       }
       board[i][j] = c;
      
    }


    public boolean isValid(int i, int j, int n, int m ,char[][] board, TrieNode root){
        return i>=0 && j>=0 && i<n && j<m && root.children.containsKey(board[i][j]);
    }

    int[][] dir = {
        {0,1},{0,-1},{1,0},{-1,0}
    };

}