class Solution {
    public int silidingWindow(char[] arr,char c, int k){
        int left = 0, diff = 0;
        int maxLen = 0;
        for(int right=0;right<arr.length;right++){
            if(arr[right] != c){
                diff++;
            }

            while(diff > k){
                if(arr[left] != c){
                    diff--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);

        }
        return maxLen;
    }

    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for(char it: s.toCharArray()) set.add(it);
        int maxLen = 0;
        for(char it: set){
            maxLen = Math.max(maxLen, silidingWindow(s.toCharArray(), it, k));
        }
        return maxLen;

        
    }
}
