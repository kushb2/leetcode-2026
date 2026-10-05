class Solution {
    public int solve(int[] cost, int n, int[] dp){
        if(n == 0) return 0;
        if(n == 1) return 0;
        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = Math.min(solve(cost, n-1, dp) + cost[n-1], solve(cost, n-2, dp)+ cost[n-2]);
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return solve(cost, cost.length, dp);
        
    }
}