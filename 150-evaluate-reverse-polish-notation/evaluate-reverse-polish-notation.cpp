class Solution {
public:
    int stringToInt(string s){
        bool negative = false;
        int i = 0;
        if(s[i] == '-') {
            negative = true;
            i++;

        }
        int ans = 0;
        for(;i<s.size();i++){// 10
            ans = ans * 10 + ( s[i] - '0');
        }
        return negative ? -1 *ans : ans;
    }
    int evalRPN(vector<string>& tokens) {
        stack<int> st;
        unordered_set<string> set;
        set.insert("+");
        set.insert("-");
        set.insert("*");
        set.insert("/");

        for(auto it: tokens){

            if(set.contains(it)){ // an operation comes 
                int second = st.top(); st.pop();
                int first = st.top(); st.pop();
                int res;
                if(it == "+"){
                    res = first + second;
                }else if(it == "-"){
                    res = first - second;
                }else if(it == "/"){
                    res = first / second;
                }else{
                    res = first * second;
                }
                st.push(res);
            }else{
                st.push(stringToInt(it));
            }
        }
        return st.top();
    }
};
