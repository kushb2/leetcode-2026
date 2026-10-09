class Solution {
    public int compress(char[] chars) {
        int left = 0, right = 0, n = chars.length;

        while(right < n){
            char c = chars[right];
            int count = 0;
            while(right < n && c == chars[right]){ // a , a, b,b,c
                right++;
                count++;
            }

            if(count == 1){
                chars[left++] = c;
            }else{
                chars[left++] = c;
                for(char it: Integer.toString(count).toCharArray()){
                    chars[left++] = it;
                }
            }
        }

        return left;

        
        
    }
}