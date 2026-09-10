class Solution {
public:
    int compress(vector<char>& chars) {
        int i=0, n = chars.size();
        int j = 0;
        while(i < n){
            int count = 0;
            char curr = chars[i];// b 
            while(i<n && chars[i] == curr) {// i = 2
                count++; i++;
            }
            chars[j++] = curr;
            if(count > 1){
                string number = to_string(count);
                for(auto it: number){
                     chars[j++] = it;
                }
            }
        }
        return j;
    }
};