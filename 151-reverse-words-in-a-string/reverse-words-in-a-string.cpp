class Solution {
public:
    string reverseWords(string s) {

        string curr;
        vector<string> word;
        for(auto it: s){
            if(it == ' '){
                if(curr.size() > 0){
                    word.push_back(curr);
                    curr = "";
                }
                
            }else{
                curr += it;
            }
        }

        if(curr.size() > 0){
            word.push_back(curr);
        }
        string ans;
        for(int i=word.size()-1;i>=0;i--){
            ans += word[i];
            ans += " ";
        }

        ans.pop_back();


        return ans;
        
    }
};