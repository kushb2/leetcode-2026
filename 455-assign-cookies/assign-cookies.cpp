class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int count = 0;
        int j=0;
        for(auto it: g){
            while(j < s.size() && it > s[j]){
                j++;
            }
            if(j == s.size()) break;
            count++;
            j++;
        }
    return count;
    }
};