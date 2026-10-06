class Solution {

    public int solve(int[] coins, int amount,int[] dp) {
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;

        if(dp[amount] != -1) return dp[amount];

        int required = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(amount >= coins[i]){
                required = Math.min(required, solve(coins, amount - coins[i], dp));
            }
        }
        return dp[amount] =  required == Integer.MAX_VALUE ? required : required+1;
        
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans =  solve(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}