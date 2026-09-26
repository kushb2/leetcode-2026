class Solution {
    boolean valid(boolean[][] arr, int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m && arr[i][j] == false;
    }
    int[][] dir = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    public void bfs(Deque<int[]> q,int[][] heights, boolean[][] arr, int n, int m){
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];
            int height = heights[i][j];
            for(int[] it: dir){
                int x = i + it[0];
                int y = j+ it[1];
                if(valid(arr, x, y, n, m) && height <= heights[x][y]){
                    arr[x][y] = true;
                    q.offer(new int[] { x, y});
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pArr = new boolean[n][m];
        boolean[][] aArr = new boolean[n][m];

        Deque<int[]> q1 = new ArrayDeque<>();
        Deque<int[]> q2 = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 || j == 0){
                    pArr[i][j] = true;
                    q1.offer(new int[] { i, j });
                }

                if(i == n-1 || j == m-1){
                    aArr[i][j] = true;
                    q2.offer(new int[] { i, j });
                }
            }
        }

        bfs(q1, heights, pArr, n, m);
        bfs(q2, heights, aArr, n, m);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pArr[i][j] && aArr[i][j]){
                    ans.add( List.of(i,j));
                }
            }
        }

        return ans;
    }
}