class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> map;
        for(auto it: s) map[it]++;
        for(auto it: t) map[it]--;

        for(auto [key, freq]: map){
            if(freq != 0) return false;
        }
        return true;

    }
};