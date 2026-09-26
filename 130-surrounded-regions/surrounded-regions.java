class Solution {
    boolean valid(char[][] board, int i, int j, int n, int m) {
        return i >=0 && j >=0 && i < n && j < m && board[i][j] == 'O'; 
    }

    int[][] dir = { {0,1},{0,-1},{1,0},{-1,0}};

    void dfs(char[][] board, int i, int j, int n, int m){
        if(!valid(board, i, j, n, m)) return;

        board[i][j] = 'B';

        for(int[] it : dir){
            int x = i + it[0];
            int y = j + it[1];

            dfs(board, x, y, n, m); 
        }


    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){// first row
            for(int j=0;j<m;j++){

                if((i == 0 || i == n-1) && board[i][j] == 'O'){
                    dfs(board, i, j, n, m);
                }

                if((j == 0 || j == m-1)&& board[i][j] == 'O'){
                    dfs(board, i, j , n, m);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'B'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
      
    }
}