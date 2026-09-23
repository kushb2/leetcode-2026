class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        if( n == 0 || s[0] == '0') return 0; // base case handled 
        vector<int> dp(n);
        dp[0] = 1; // will be a valid digit as leading zero alreay handled 
        if(n == 1) return dp[0];

        int signleDigit = s[1] - '0';
        if(signleDigit >= 1 && signleDigit <= 9){
                dp[1] += dp[0];
            }
        int doubleDigit = (s[0] - '0')*10 + (s[1] - '0');  
          if(doubleDigit >= 10 && doubleDigit <= 26){
                dp[1] +=1;
            }


        for(int i=2;i<n;i++){
            // taken as a single char 
             int oneDigit = s[i] - '0';
            if(oneDigit >= 1 && oneDigit <= 9){
                dp[i] = dp[i-1];
            }

            int combine = (s[i-1] - '0')*10 + (s[i] - '0');
            if(combine >= 10 && combine <= 26){
                dp[i] += dp[i-2]; 
            }
        }
        return dp[n-1];

        
    }
};