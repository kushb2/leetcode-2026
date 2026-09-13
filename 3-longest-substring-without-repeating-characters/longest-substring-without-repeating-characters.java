class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for(int right=0;right < n ;right++){
            // add element 
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while(map.get(curr) > 1){// duplicate instance 
                char rightChar = s.charAt(left);
                map.put(rightChar, map.get(rightChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;        
    }
}