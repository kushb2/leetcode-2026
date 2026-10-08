class Solution {

    public boolean isValid(int m, int n, int i, int j) {
        return i>=0 && j>=0 && i<n && j<m;
    }

    public int solve(int[][] dp, int n, int m, int i, int j){
        if(!isValid(m, n, i , j)) return 0;

        if(i == n-1 && j == m-1) return dp[i][j] = 1;

        if(dp[i][j] != -1) return dp[i][j];

        int path = 0;
        path += solve(dp, n,m, i, j+1);
        path += solve(dp,  n, m, i+1, j);
        // System.out.println(path + " " + i + " " + j);
        return dp[i][j] = path;
    }


    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];
        for(int i=0;i<dp.length;i++)  Arrays.fill(dp[i], -1);
         solve(dp, n , m, 0 , 0);
         return dp[0][0];
        
    }
}