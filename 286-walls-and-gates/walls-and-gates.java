class Solution {
    int[][] dir = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    boolean valid(int[][] rooms, int i, int j , int n, int m){
        return i>=0 && j >=0 && i < n && j < m && rooms[i][j] == Integer.MAX_VALUE;
    }

    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rooms[i][j] == 0){
                    q.add(new int[] { i, j, 0});
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

                if(valid(rooms, x, y, n, m)){
                    rooms[x][y] = distance+1;
                    q.add(new int[]{x,y,distance+1});
                }
            }

        }
     
    }
}