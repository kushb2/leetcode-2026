class Solution {
public:
    int solve(vector<int>& coins, int amount, vector<int> &dp) {
        if(amount == 0){
            dp[0] = 0;
            return dp[0];
        }
        if(amount < 0) return -1;
        if(dp[amount] != -2) return dp[amount];
        int ans = INT_MAX;
        for(int i=0;i<coins.size();i++){
            if(coins[i] <= amount){
                int count = solve(coins, amount - coins[i], dp);
                if(count != -1){
                     ans = min(count+1, ans);
                }
            }
        }
        dp[amount] = ans == INT_MAX ? -1 : ans;
        return dp[amount];
    }
    int coinChange(vector<int>& coins, int amount) {

        vector<int> dp(amount+1, -2);
        return solve(coins, amount, dp);
    }
};