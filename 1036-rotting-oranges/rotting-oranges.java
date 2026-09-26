class Solution {

     int[][] dir = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    boolean valid(int[][] rooms, int i, int j , int n, int m){
        return i>=0 && j >=0 && i < n && j < m && rooms[i][j] == 1;// fresh 
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[] { i, j, 0});
                }
            }
        }

        int timeTaken = 0;
        while(!q.isEmpty()){
            int[] gate = q.poll();
            int i = gate[0];
            int j = gate[1];
            int time = gate[2];

            for(int[] it: dir){
                int x = it[0] + i;
                int y = it[1] + j;

                if(valid(grid, x, y, n, m)){
                    timeTaken = Math.max(timeTaken, time+1);
                    grid[x][y] = 2;
                    q.add(new int[]{x,y,time+1});
                }
            }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }     
            }
        }

        return timeTaken;


        
    }
}