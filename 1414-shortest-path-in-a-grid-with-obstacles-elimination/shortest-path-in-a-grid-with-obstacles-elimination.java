
import java.security.KeyFactory;class Solution {
    int ans;
    int INF = (int)1e9;

    public boolean valid(int[][] grid,int i, int j, int n, int m, int k,boolean[][][] visited){
        return i>=0 && j>=0 && i<n && j<m && k>=0 && visited[i][j][k] == false && (grid[i][j] == 0 || grid[i][j]==1 && k>0);
    }

    int[][] dir = {
        {0,1},{0,-1},{1,0},{-1,0}
    };


    public int shortestPath(int[][] grid, int k) {
        int ans = 0;
        int n = grid.length, m = grid[0].length;
        boolean[][][] visited = new boolean[n][m][k+1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0,0,0,k});
        visited[0][0][k] = true;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];
            int step = cell[2]; 
            int remainingObs = cell[3];

            if(i == n-1 && j == m-1) return step;

            if(grid[i][j] == 1){
                remainingObs--;
            }
            
            for(int[] it: dir){
                int x = i + it[0];
                int y = j + it[1];
                 if(valid(grid, x, y, n, m, remainingObs, visited)){
                    visited[x][y][remainingObs] = true;
                    q.offer(new int[] {x,y,step+1,remainingObs});
                 }
            }
        }



        return -1;
        
    }
}