class Solution {
    int[][] dir = {
        {0,1},{0,-1},{1,0},{-1,0}
    };

    public boolean valid(int i, int j, int n, int m, int[][] matrix, int prevValue){
        return i>=0 && j>=0 && i<n && j<m && prevValue < matrix[i][j];
    }

    public int dfs(int i, int j, int n, int m, int[][] matrix, int[][] dp, int prevValue){
        if(!valid(i, j, n, m , matrix, prevValue)){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        for(int[] it: dir){
            int x = it[0] + i, y = it[1] + j;
            ans = Math.max(ans, dfs(x, y, n, m, matrix, dp, matrix[i][j]));
        }

        return dp[i][j] = ans+1;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] it : dp) Arrays.fill(it, -1); // not visited 

        int ans = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans, dfs(i,j, n, m , matrix, dp , -1));
            }
        }

        return ans;
        
    }
}