class Solution {
    
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length(),left = 0, minLen = Integer.MAX_VALUE, matchedChar = 0;
        String ans = "";
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0)+1);
        Map<Character, Integer> sMap = new HashMap<>();

        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0)+1);

            if(sMap.containsKey(c) && tMap.containsKey(c) && sMap.get(c).equals(tMap.get(c))){
                matchedChar++;
            }

            while(matchedChar == tMap.size()){ // all unique char matched 
                if(minLen > right-left+1){
                    minLen = right-left+1;
                    ans = s.substring(left, right+1);
                }
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar)-1);
                if(sMap.containsKey(leftChar) && tMap.containsKey(leftChar) && sMap.get(leftChar).equals(tMap.get(leftChar)-1)){
                    matchedChar--;
                }
                left++;
            }
        }
        return ans;

    }
}