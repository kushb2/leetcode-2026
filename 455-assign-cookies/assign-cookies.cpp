class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int greedIndex=0, cookieIndex = 0;
        int greedSize = g.size(), cookieSize = s.size();
        while(greedIndex < greedSize && cookieIndex < cookieSize){
            if(g[greedIndex] <= s[cookieIndex]){
                greedIndex++;
            }
            cookieIndex++;
        }
        return greedIndex;
        
    }
};