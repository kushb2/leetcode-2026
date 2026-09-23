class Solution {
public:
   

    char small(char c) {
        if(c >= 'a' && c <= 'z'){
            return c;
        }else {
            return 'a' + c - 'A';
        }
    }
    bool isPalindrome(string s) {
        int left = 0, right = s.size()-1;        
        while(left < right){
            while(left < right && !isalnum(s[left])){
                left++;
            }

            while(right > left && !isalnum(s[right])){
                right--;
            }

            char leftChar = isalnum(s[left]) ? tolower(s[left]) : s[left];
            char rightChar = isalnum(s[right]) ? tolower(s[right]) : s[right];

            // convert to small 

            if(leftChar != rightChar){
                return false;
            }
            left++; right--;
        }
        return true;
        
    }
};
// "A man, a plan, a canal: Panama"
// first we can think of clean the string 
// then call palaindrome function
// but look at your observation how you mind did it 
// it use two pointer and skip if not a valid char 
// what is not a valid char 
// anything which is either between A - Z and a - Z
// everything else is invalid char 
// how to compare , convert capital latter to small 
// but how to convert capital latter to small leter
// A - convert to a; 'a' + A - 'A' // convert to small  
