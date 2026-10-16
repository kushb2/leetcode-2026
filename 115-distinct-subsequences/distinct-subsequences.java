
import java.lang.reflect.Array;class Solution {
    public int solve(char[] s, char[] t, int i, int j,int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s[i] != t[j]){
            return dp[i][j] = solve(s,t, i-1, j,dp);
        }else{
            return dp[i][j] =  (solve(s,t, i-1, j-1,dp) + solve(s,t, i-1, j,dp)); 
        }
    }

    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        for(int[] it: dp) Arrays.fill(it,-1);

        return solve(s.toCharArray(), t.toCharArray(), n-1,m-1, dp);
        
    }
}