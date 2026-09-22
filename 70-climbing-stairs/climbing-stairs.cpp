class Solution {
public:
    int solve(vector<int> &dp, int n){
        if(n <= 2) return n;

        if(dp[n] != -1) return dp[n];

        int ways = solve(dp, n-1) + solve(dp, n-2);
        dp[n] = ways;
        return ways;

    }
    int climbStairs(int n) {
        if(n == 1) return 1;
        vector<int> dp(n+1, -1);
        dp[0] = 1;
        dp[2] = 2;
        solve(dp,n);
        return dp[n];


        
    }
};