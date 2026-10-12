class Solution {
    public int solve(int amount, int[] coins, int idx,int[][] dp){
        if(amount == 0){
            return 1;
        }
        if(amount < 0){
            return 0;
        }
        if(idx < 0) {
            return 0; // no conbination found 
        }
        if(dp[amount][idx] != -1) return dp[amount][idx];

        int take = solve(amount - coins[idx], coins, idx, dp);
        int skip = solve(amount, coins, idx-1, dp);

        return dp[amount][idx] = take+skip;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];
       
       // one possible way to make amount 0
        for(int i=0;i<=n;i++) dp[0][i] = 1;

        for(int i=1;i<=amount;i++){ // amount
            for(int j=1;j<=n;j++){ // coint
                int coin = coins[j - 1];
                int take = i - coin >= 0 ?  dp[i-coin][j] : 0;
                int skip = dp[i][j-1];
                dp[i][j] = take+skip;
            }
               
        }

        return dp[amount][n];


        
    }
}