class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int left = 0, n = s.size(), maxLen = 0;
        unordered_map<char,int> map;
        for(int right=0;right<n;right++){
            char curr = s[right];
            map[curr]++;

            while(map[curr] > 1){
                map[s[left]]--;
                left++;
            }
            maxLen = max(maxLen, right - left + 1);
        }
        return maxLen;
        
    }
};
