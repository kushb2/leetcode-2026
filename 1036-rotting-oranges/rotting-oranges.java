class Solution {

     int[][] dir = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    boolean valid(int[][] rooms, int i, int j , int n, int m){
        return i>=0 && j >=0 && i < n && j < m && rooms[i][j] == 0;// fresh 
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    grid[i][j] = -2; // rotten
                    q.add(new int[] { i, j, 0});
                }else if(grid[i][j] == 1){
                    grid[i][j] = 0; // fresh
                }else{
                    grid[i][j] = -5;// empty
                }
            }
        }


        while(!q.isEmpty()){
            int[] gate = q.poll();
            int i = gate[0];
            int j = gate[1];
            int distance = gate[2];

            for(int[] it: dir){
                int x = it[0] + i;
                int y = it[1] + j;

                if(valid(grid, x, y, n, m)){
                    grid[x][y] = distance+1;
                    q.add(new int[]{x,y,distance+1});
                }
            }

        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    return -1;
                }else if(grid[i][j] != -5){
                    ans = Math.max(grid[i][j], ans);
                }      
            }
        }

        return ans;


        
    }
}