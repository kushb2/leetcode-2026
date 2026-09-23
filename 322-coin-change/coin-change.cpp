class Solution {
public:
   
    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(), coins.end());
        int n = coins.size();
        vector<int> dp(amount+1);
        dp[0] = 0;
    
        for(int i=1;i<=amount;i++){
            int ans = INT_MAX;
            for(int j=0;j<coins.size();j++){
                if(coins[j] <= i){
                    int count = dp[i-coins[j]];
                    if(count != -1) {
                         ans = min(count+1, ans);
                    }
                }else{
                    break;
                }
            }
            dp[i] = ans == INT_MAX ? -1 : ans; 
        }
        return dp[amount];
    }
};