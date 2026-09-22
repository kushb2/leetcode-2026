class Solution {
public:
    bool isAnagram(string s, string t) {
        // what is an anagram every single char of s should apprean in t 
        // with same frequency if i add s frwq and minum t freq then last freq should be zero
        if(s.size() != t.size()) return false;
        unordered_map<char, int> map;
        for(int i=0;i<s.size();i++){
            map[s[i]]++;
            map[t[i]]--;
        }

        for(auto [key, freq]: map){
            if(freq > 0) return false;
        }
        return true;
       
        
        
    }
};