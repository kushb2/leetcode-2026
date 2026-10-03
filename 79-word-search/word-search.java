class Solution {
    public boolean isValid(char[][] board, String word,int i, int j,int n, int m ,int idx){
        return i>=0 && j>=0 && i<n && j<m && board[i][j]  != '#'   && board[i][j]  == word.charAt(idx);
    }

    int[][] dir = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    public boolean dfs(char[][] board, String word,int i, int j,int n, int m , int idx){
        if(idx == word.length()) return true;

        if(!isValid(board, word,i, j, n,m, idx)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        for(int[] it : dir){
            int x = it[0]+i;
            int y = it[1]+j;

            if(dfs(board, word, x, y, n, m, idx+1)){
                return true;
            }

        }
        board[i][j] = temp;

        return false;

    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        char startingChar = word.charAt(0); 
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c = board[i][j];
                map.put(c, map.getOrDefault(c, 0)+1);
            }
        }
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : word.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        for(var it : map2.entrySet()){
            if(!map.containsKey(it.getKey())) return false;
            if(map.get(it.getKey()) < it.getValue()) return false;
        }

        


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == startingChar){
                    if(dfs(board, word, i, j, n, m, 0)){
                        return true;
                    }
                }
            }
        }
        return false;

    
    }
}