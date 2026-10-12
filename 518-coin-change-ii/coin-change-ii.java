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
        int[][] dp = new int[amount+1][coins.length];
        for(int[] it: dp) Arrays.fill(it, -1);
        return solve(amount, coins, coins.length-1, dp);
        
    }
}