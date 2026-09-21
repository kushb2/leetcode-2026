class Solution {
public:
    
// ababcbacadefegdehijhklij
// ababcbaca


    vector<int> partitionLabels(string s) {
        map<char,int> charLastIndex;
        for(int i=0;i<s.size();i++){
            charLastIndex[s[i]] = i;
        }
        
        vector<int> ans;
        int statingIndexOfPartition = 0, right = 0;
        for(int left = 0;left< s.size();left++){
            char currChar = s[left];
            int lastIndex = charLastIndex[currChar];
            right = max(lastIndex, right);
            if(left == right){
                ans.push_back(right - statingIndexOfPartition + 1);
                statingIndexOfPartition = left+1;
            }
        }

        return ans;

        return ans;



        
    }
};