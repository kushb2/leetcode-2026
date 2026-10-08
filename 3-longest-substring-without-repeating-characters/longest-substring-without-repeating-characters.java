class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), left = 0, maxLen = 0;
        for(int right = 0; right<n;right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);

            while(map.get(c) > 1){
                char temp = s.charAt(left);
                map.put(temp, map.get(temp)-1);
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);


        }
        return maxLen;
        
    }
}