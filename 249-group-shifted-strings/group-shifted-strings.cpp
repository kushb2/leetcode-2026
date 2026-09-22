class Solution {
public:
    string convertToKey(string s){
        string converted = "0,";

        for(int i=1;i<s.size();i++){
            int diff = abs(s[i-1] - s[i] + 26) % 26;
            converted += to_string(diff) + ",";
        }

        return converted;

    }
    vector<vector<string>> groupStrings(vector<string>& strings) {
        // two string can be group together if each char index 
        // diff is same 
        // pick one string and find all its grouping 
        // maintain a visited array as well 

        // abc 0+1+1
        // bcd 0+1+1

        unordered_map<string, vector<string>> map;

        for(auto it: strings){
            string key = convertToKey(it);
            map[key].push_back(it);
        }

        vector<vector<string>> ans;
        for(auto [key, value]: map){
            ans.push_back(value);
        }

        return ans;

    }
};