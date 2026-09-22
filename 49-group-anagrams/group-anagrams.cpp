class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map;
        //idea is all anagram if i sort then they become requal 
        // so i can group all anagram by sorting them using sort value as key 

        for(auto it: strs){
            string sortedIt = it;
            sort(sortedIt.begin(), sortedIt.end());
            map[sortedIt].push_back(it);
        }
        vector<vector<string>> ans;
        for(auto [key, value]: map){
            ans.push_back(value);
        }
        return ans;
    }
};