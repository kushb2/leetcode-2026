class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        int maxLen = 1;
        int finalLeft = 0;
        int finalRight = 0;
        for(int i=0;i<n-1;i++){
            int left = i, right = i;

            while(left >= 0 && right < n && s[left] == s[right]){
                left--; right++; // (3 + 1) - 1 => 3 
            }
            if((right - left - 1) > maxLen){
                maxLen = right - left - 1;
                finalLeft = left+1;
                finalRight = right-1;
            }

        }

        for(int i=0;i<n-1;i++){
            int left = i, right = i+1;

            while(left >= 0 && right < n && s[left] == s[right]){
                left--; right++; // (3 + 1) - 1 => 3 
            }
            if((right - left - 1) > maxLen){
                maxLen = right - left - 1;
                finalLeft = left+1;
                finalRight = right-1;
            }

        }
        string ans;
        for(int i = finalLeft; i<= finalRight;i++){
            ans += s[i];
        }
        return ans;
    }
};