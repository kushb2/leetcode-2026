class Solution {
    public void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++; end--;
        }
    }

    public void reverseWords(char[] s) {
        int n = s.length;
        reverse(s, 0, n-1);
        int i=0, start = 0;
        while(i<n){
            start = i;    
            while(i<n && s[i] != ' ') i++; // t h e _
            reverse(s, start, i-1);
            i++;
        }

    }
}