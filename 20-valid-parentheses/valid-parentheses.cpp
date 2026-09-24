class Solution {
public:
    bool isValid(string s) {
        unordered_map<char, char> map;// for each closing bracked , there should an opening bracket waiting to be closed.
        map[')'] = '(';
        map[']'] = '[';
        map['}'] = '{';
        stack<char> st; // opening bracket waiting to be closed 

        for(auto it: s){
            if(map.contains(it)){// closing bracket 
                int watingOpeningBrakcet = st.empty() ? '*' : st.top(); // handle stack empty case
                if(map[it] != watingOpeningBrakcet){
                    return false;// other closing bracket is waiting 
                }else{
                    st.pop();
                }
            }else{
                st.push(it); // wait for a closing bracket
            }
        }

        return st.empty(); // is any open bracket waiting to be open 
        
    }
};