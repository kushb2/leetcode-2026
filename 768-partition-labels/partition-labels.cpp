class Solution {
public:
    bool allFreqCover(map<char,int> charByFreq, map<char,int> currSubStringFreq){
        for(auto [it, freq]: currSubStringFreq){
            if(charByFreq[it] != freq) return false;
        }
        return true;
    }
    vector<int> partitionLabels(string s) {
        map<char,int> charByFreq, currSubStringFreq;
        for(auto it: s){
            charByFreq[it]++;
        }
        vector<int> ans;
        int left = 0;
        for(int right = 0; right< s.size(); right++){
            currSubStringFreq[s[right]]++;

            if(allFreqCover(charByFreq,currSubStringFreq)){
                ans.push_back(right - left + 1);
                currSubStringFreq.clear();
                left = right+1;
                continue;
            }
        }

        return ans;



        
    }
};