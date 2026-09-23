class Solution {
public:
    int solve(string s, int n, vector<int> &dp){

        if(n == 0){
            dp[0] = 1;
            return dp[0];
            
        }
        if( n < 0) return 1; // 12 leaves nothing as prefic

        if(dp[n] != -1) return dp[n];

        int ans = 0;
        int oneDigit = s[n] - '0';
        if( oneDigit >= 1 && oneDigit <= 9){
            ans += solve(s, n-1, dp);
        }
        int twoDigit = (s[n-1] - '0')*10 + (s[n] - '0');// 12
        if(twoDigit >= 10 && twoDigit <= 26){
            ans += solve(s, n-2, dp);
        }
        dp[n] = ans;
        return ans;
    }
    int numDecodings(string s) {
        if(s[0] == '0') return 0;
        vector<int> dp(s.size(), -1);
        return solve(s, s.size()-1, dp);
    }
};