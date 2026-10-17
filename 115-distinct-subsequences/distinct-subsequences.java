class Solution {
    public int solve(String s, String t, int n, int m,int[][] dp){
        // there is no element left in n 
        

        if(m == 0){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        if( dp[n][m] != -1) return  dp[n][m];

        if(s.charAt(n-1) == t.charAt(m-1)){
            int skip = solve(s,t,n-1, m,dp);
            int take = solve(s,t,n-1,m-1,dp);
            return  dp[n][m] = skip + take;
        }else{
            int skip = solve(s,t,n-1, m,dp);
            return dp[n][m] = skip;
        }

       
    }

    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] it: dp) Arrays.fill(it, -1);

        return solve(s,t, n,m,dp);
        
    }
}