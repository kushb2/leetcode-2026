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
                if(st.empty()){// no one is waiting 
                    return false;
                }else if(st.top() == map[it]){// found same type of opening bracket
                    st.pop(); // close this bracket , it is no longer waiting .
                }else{
                    return false;// other closing bracket is waiting 
                }
            }else{
                st.push(it); // wait for a closing bracket
            }
        }

        return st.empty(); // is any open bracket waiting to be open 
        
    }
};