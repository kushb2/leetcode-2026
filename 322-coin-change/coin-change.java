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
        dp[0] = 0;
        
        for(int i=1;i<=amount;i++){
            int required = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i >= coins[j]){
                    required = Math.min(dp[i - coins[j]], required);
                }
            }
            dp[i] = required == Integer.MAX_VALUE ? Integer.MAX_VALUE : required+1;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        
    }
}