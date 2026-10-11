
class Solution {
    private final int INF = (int) 1e9;

    public int solve(int[] coins, int amount, int[] dp) {
        if(amount == 0) return 0;
        if(amount < 0) return INF;
        int min = INF;
        if(dp[amount] != -1) return dp[amount];
        for(int i=0;i<coins.length;i++){
            min = Math.min(solve(coins, amount - coins[i], dp), min);
        }
        return dp[amount] = min + 1;
    }

    public int bottomUp(int[] coins, int amount, int[] dp){
        int n = coins.length;
        dp[0] = 0;

        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                }
            }
        }

        return dp[amount];

    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,INF);
        int ans = bottomUp(coins, amount, dp);
        return ans >= INF ? -1 : ans;

    }
}