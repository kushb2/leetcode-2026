
class Solution {
    public int solve(int m, int n,int[][] dp){
        if(m == 0 || n == 0) return 1;
        if(m < 0 || n < 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        return dp[m][n] = solve(m-1,n,dp) + solve(m, n-1,dp);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] it: dp) Arrays.fill(it,-1);
        // for(int i=0;i<=m;i++) dp[i][0] = 1;
        // for(int i=0;i<=n;i++) dp[0][i] = 1;

        // Your code goes here
        return solve(m-1,n-1,dp);
    }
}