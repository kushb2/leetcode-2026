class Solution {
public:
    bool isNum(char s){
        return (s >= '0' && s <= '9');
    }
    int myAtoi(string s) {
        int i = 0, n = s.size();

        // rule 1 remove all whitespace 
        while(i<n && s[i] == ' ') i++;
        // i is point to next char found other thean ' '

        // rule 2 sign 
        bool positive = true;

        if(i < n  ) {
            if(s[i] == '-'){
                positive = false;
                i++;
            }else if(s[i] == '+'){
                i++;
            }
        }
        // i is pointing to next char of sign 

        // rule 3 skip leading zero 
        while (i<n && s[i] == '0') i++;
        int ans = 0;
        while (i<n && isNum(s[i])) {
            int currInt = s[i] - '0';

            if(ans > INT_MAX/10 || (ans == INT_MAX/10 && currInt > INT_MAX % 10)){
                return positive ? INT_MAX : INT_MIN;
            }
            
            
            ans = ans * 10 + currInt;
            i++;
        }
        return positive ? ans : ans * -1;

    
        
    }
};