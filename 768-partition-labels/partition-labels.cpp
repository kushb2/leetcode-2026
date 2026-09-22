class Solution {
public:
    vector<int> partitionLabels(string s) {
        unordered_map<char, int> lastIndex;
        for(int i=0;i<s.size();i++) lastIndex[s[i]] = i;
        int start = 0;
        vector<int> ans;
        int n = s.size();
        while(start < n){
            int end = lastIndex[s[start]];
            int curr = start;
            while( curr != end){
                end = max(end, lastIndex[s[curr]]);
                curr++;
            }
            ans.push_back(end-start+1);
            start = end+1;
        }
        return ans;
    }
};