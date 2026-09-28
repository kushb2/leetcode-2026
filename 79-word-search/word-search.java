class Solution {

    int[][] dir = {
        {0,1},{0,-1},{1,0},{-1,0}
    };

    public boolean valid(char[][] board, String word, int i, int j, int n, int m, int idx){

        return i >=0 && j >=0 && i<n && j<m && word.charAt(idx) == board[i][j];
    }
    public boolean find(char[][] board, String word, int i, int j, int n, int m, int idx){
        if(idx == word.length())
            return true;

        if(!valid(board, word, i , j, n, m , idx)) return false;    

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] it: dir){
            int x = i + it[0];
            int y = j + it[1];

            if(find(board, word, x, y, n, m, idx+1))
                return true;
        }

        board[i][j] = temp;

        return false;


    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0) && find(board,word, i, j, n, m, 0)){
                    return true;
                }
            }
        }
        return false;
        
    }
}