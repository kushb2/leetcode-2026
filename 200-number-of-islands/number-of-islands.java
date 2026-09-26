class Solution {

    int[][] dir = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    boolean valid(char[][] grid, int i, int j , int n, int m){
        return i >=0 && j >=0 && i < n && j < m && grid[i][j] == '1';
    }

    void dfs(char[][] grid, int i, int j , int n, int m){

        if(!valid(grid, i, j, n,m)) return;

        grid[i][j] = '0';

        for(int[] it: dir){
            int x = i + it[0];
            int y = j + it[1];
            dfs(grid, x, y, n, m);
        }

       

    }
   
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int num_islands = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    ++num_islands;
                    dfs(grid, i, j, n , m);
                }
            }
        }
        return num_islands;
        
    }
}