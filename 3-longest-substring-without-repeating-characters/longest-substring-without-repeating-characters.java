class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for(int right=0;right < n ;right++){
            // add element 
            char curr = s.charAt(right);

            if(map.containsKey(curr)){// ccurr already present 
                left = Math.max(map.get(curr)+1, left);
            }
            map.put(curr, right);
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;        
    }
}