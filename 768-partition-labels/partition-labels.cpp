class Solution {
public:
    vector<int> partitionLabels(string s) {
        map<int,int> lastOccurenceMap;
        int n = s.size();
        for(int i=0;i<n;i++){
            lastOccurenceMap[s[i]] = i;
        }

        int i = 0;
        vector<int> ans;
        while(i < n){
            int j = i;
            int lastOccurence = lastOccurenceMap[s[j]];
            while(j != lastOccurence){
                lastOccurence = max(lastOccurence, lastOccurenceMap[s[j]]);
                j++;
            }
            ans.push_back(j-i+1);
            i = j+1;

        }

        return ans;
        
    }
};