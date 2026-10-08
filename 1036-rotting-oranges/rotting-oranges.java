class Solution {
    int[][] dir = {
        {0,1}, {0,-1},{1,0},{-1,0}
    };

    public boolean valid(int[][] grid, int i , int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m && grid[i][j] == 1;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length, freshOrangeCount = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[] { i, j, 0});
                }else if(grid[i][j] == 1){
                    freshOrangeCount++;
                }
            }
        }

        int totalTime = 0;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];
            int time = cell[2];
            totalTime = time;

            for(int[] it: dir){
                int x = i + it[0];
                int y = j + it[1];

                if(valid(grid, x, y, n,m)){
                    freshOrangeCount--;
                    grid[x][y] = 2;
                    q.offer(new int[] { x, y, time+1});
                }
            }
        }

        return freshOrangeCount == 0 ? totalTime : -1;
        
    }
}