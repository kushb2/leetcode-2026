class Solution {
public:
  int expend(string s, int l , int r, int n){
        int count = 0;
        while(l >= 0 && r < n && s[l] == s[r]){
            l--; r++;
            count++;
        }
        return count;
    }
    
    int countSubstrings(string s) {
         int n = s.size();
        int count = 0;
        for(int i=0;i<n;i++){
            count += expend(s, i, i, n);
            count += expend(s, i, i+1, n);
        }

        return count;
    }
};