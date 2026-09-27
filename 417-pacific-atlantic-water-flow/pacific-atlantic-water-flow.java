class Solution {
    boolean valid(boolean[][] arr, int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m && arr[i][j] == false;
    }
    int[][] dir = {
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };

    public void dfs(int[][] heights, boolean[][] arr,int i, int j, int n, int m, int prevHeight){

        if(!valid(arr, i, j, n, m)) return;
        if(prevHeight > heights[i][j]) return;
        arr[i][j] = true;

        for(int[] it: dir){
            int x = i + it[0];
            int y = j + it[1];
            dfs(heights, arr, x, y, n, m, heights[i][j]);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pArr = new boolean[n][m];
        boolean[][] aArr = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i == 0 || j == 0) && pArr[i][j] == false){
                    dfs(heights,pArr, i,j,n,m, 0);
                }

                if((i == n-1 || j == m-1) && aArr[i][j] == false){
                    dfs(heights,aArr, i,j,n,m, heights[i][j]);
                }
            }
        }

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