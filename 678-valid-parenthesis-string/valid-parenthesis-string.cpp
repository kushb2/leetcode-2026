class Solution {
public:
    bool checkValidString(string s) {
        stack<char> extraOpeningBracket;
        stack<char> astrick;

        for(int i=0;i<s.size();i++){
            char currChar = s[i];
            if(currChar == '('){
                extraOpeningBracket.push(i);
            }else if(currChar == '*'){
                astrick.push(i);
            }else {
                if(!extraOpeningBracket.empty()){
                    extraOpeningBracket.pop();
                }else if(!astrick.empty()){
                    astrick.pop();
                }else{
                    return false;
                }
            }
        }

        while(!extraOpeningBracket.empty()){
            if(astrick.empty()) return false;
            int openingBracketIndex = extraOpeningBracket.top();
            int astrickIndex = astrick.top();
            if(openingBracketIndex > astrickIndex){
                return false; // if opening brack comes later then astrick
            }
            extraOpeningBracket.pop();
            astrick.pop();
        }

        return extraOpeningBracket.empty();
        
    }
};