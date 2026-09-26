class Solution {
     int[][] dir = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    boolean valid(int[][] grid, int i, int j , int n, int m){
        return i >=0 && j >=0 && i < n && j < m && grid[i][j] == 1;
    }

    int dfs(int[][] grid, int i, int j , int n, int m){

        if(!valid(grid, i, j, n,m)) return 0;

        grid[i][j] = 0;
        int area = 0;
        for(int[] it: dir){
            int x = i + it[0];
            int y = j + it[1];
            area += dfs(grid, x, y, n, m);
        }
        return area + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxArea = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j, n , m);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}