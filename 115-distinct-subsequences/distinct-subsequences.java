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
        // end from index i , j , no of possible way to construct t. 
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int i=1;i<=m;i++) dp[0][i] = 0; // dp[0][0] form 1 to 0 . 

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    int skip = dp[i-1][j];
                    int take = dp[i-1][j-1];
                    dp[i][j] = skip + take;
                }else{
                    int skip = dp[i-1][j];
                    dp[i][j] = skip;
                }
            }
        }
        
        return dp[n][m];
        
    }
}