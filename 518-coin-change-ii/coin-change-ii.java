
class Solution {
    public int solve(int amount, int[] coins,int n, int idx, int[][] dp){
        if(amount == 0) return dp[amount][idx] = 1;
        if(idx == n) return dp[amount][idx] = 0;

        if(dp[amount][idx] != -1) return dp[amount][idx];

        if(coins[idx] > amount){
            return dp[amount][idx] = solve(amount, coins, n, idx+1,dp);
        }

        int take = solve(amount - coins[idx],coins, n, idx, dp);
        int skip = solve(amount, coins, n, idx+1, dp);
        return dp[amount][idx] = take + skip;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][coins.length+1];
        for(int[] it: dp){
             Arrays.fill(it, -1);
        }
       

        return solve(amount, coins,n, 0, dp);
        
    }
}