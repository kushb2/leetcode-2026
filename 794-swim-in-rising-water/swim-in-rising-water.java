class Solution {
    public boolean isValid(int i, int j, int n, int m,int mid, boolean[][] visited, int[][] grid){
        return i>=0 && j>=0 && i<=n && j<=m && visited[i][j] == false && grid[i][j] <= mid;
    }
    int[][] dir = {
        {0,1},{0,-1},{1,0},{-1,0}
    };
    public boolean dfs(int i, int j, int n, int m ,int mid, int[][] grid,boolean[][] visited){
        if(i == n && j == m){
            return true;
        }
        if(!isValid(i,j, n,m, mid,visited, grid)){
            return false;
        }

        visited[i][j] = true;

        for(int[] it: dir){
            int x = it[0] + i;
            int y = it[1] + j;
            if(dfs(x, y, n, m, mid, grid, visited)){
                return true;
            }
        }

        return false;




    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = Math.max(grid[0][0], grid[n-1][n-1]);
        int right = 0;
        for(int[] x: grid){
            for(int y: x){
                right = Math.max(y, right);
            }
        }
        int ans = right;
        while(left <= right){
            // mid , with mid = t time passed can i move form (0,0) to (n-1)(n-1)
            int mid = left + (right-left)/2; 
            boolean[][] visited = new boolean[n][n];

           boolean reached =  dfs(0,0,n-1, n-1, mid, grid, visited);

           if(reached){
            ans = Math.min(mid, ans);
            right = mid-1;
           }else {
            left = mid+1;
           }
        }

        return ans;
        
    }
}