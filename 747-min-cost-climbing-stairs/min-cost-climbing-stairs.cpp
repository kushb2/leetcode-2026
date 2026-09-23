class Solution {
public:
    int solve(vector<int>& dp,vector<int>& cost, int n){
        if(n <= 1){
            dp[n] = 0;
            return 0;
        }

        if(dp[n] != -1) return dp[n];

        dp[n] =  min(
            (cost[n-1] + solve(dp, cost, n-1) ),
            (cost[n-2] + solve(dp, cost, n-2) )
        );
        return dp[n];
    }


    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size();
        vector<int> dp(n+1, -1);
        return solve(dp, cost, n);
        
    }
};