class Codec {
public:

    // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        string s;
        for(auto it: strs){
            int n = it.size();
            s += to_string(n) + "#" + it;
        }

        return s;
        
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        // 5#Hello5#world 
        // while string is left to iterate 
        // 1 while look till i get a # i keep on parsing the number 
        // take next n element as first string 
        // repate again
        int i=0, n = s.size();
        vector<string> ans;
        while(i<n){

            int len = 0;
            while(i<n && s[i] != '#'){
                len = len*10 + s[i] - '0';
                i++;
            }
            i++;
            string word;
            while(i<n && len > 0){
                word += s[i];
                i++;
                len--;
            }
            ans.push_back(word);
        }
        return ans;
        
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.decode(codec.encode(strs));

// "Hello","World"
// 5#Hello5#world 
// get length 
// length + "#" + string

// 5#Hello5#world 
// while string is left to iterate 
// 1 while look till i get a # i keep on parsing the number 
// take next n element as first string 
// repate again