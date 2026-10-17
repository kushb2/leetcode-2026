class Solution {
    int[][] dir = {
        {0,1},{1,0},{0,-1},{-1,0}
    };

    public boolean valid(int i, int j, int n, int m, int[][] matrix, int prevValue){
        return i>=0 && j>=0 && i<n && j<m && prevValue < matrix[i][j];
    }
    public int dfs(int i, int j, int n, int m, int[][] matrix, int[][] dp, int prevValue){

        // check valid 
        if(!valid(i,j,n,m,matrix, prevValue)){
            return 0;
        }

        // its already calculated 
        if(dp[i][j] != -1) return dp[i][j];

        // goto all direction 
        int maxPathLen = 0;
        for(int[] it: dir){
            int x = it[0] + i;
            int y = it[1] + j;
            // find the max len coming from all 4 direction
            maxPathLen = Math.max(maxPathLen, dfs(x,y,n,m,matrix, dp , matrix[i][j]));
        }
        return dp[i][j] = 1 + maxPathLen; // 1+ => including (i,j) cell 
    }

    public int longestIncreasingPath(int[][] matrix) {
        // DFS // evety time i find max increasing path len i will store 
        // so i do not need to cal again
        int n = matrix.length, m = matrix[0].length;

        // for i,j store the max increasding path len starting from i,j 
        int[][] dp = new int[n][m];
        for(int[] it: dp) Arrays.fill(it, -1); // -1 , we can not calculate ans for this i,j 

        int maxPathLen = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxPathLen = Math.max(maxPathLen, dfs(i,j,n,m,matrix, dp,-1));
            }
        }

        return maxPathLen;
        
    }
}