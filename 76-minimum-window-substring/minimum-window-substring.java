class Solution {
    public boolean isEqual(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        for(var it: tMap.entrySet()){
            if(!sMap.containsKey(it.getKey()) || sMap.get(it.getKey()) < it.getValue()) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length(), left = 0, minLen = Integer.MAX_VALUE;
        String ans = "";
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0)+1);
        Map<Character, Integer> sMap = new HashMap<>();

        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0)+1);

            while(isEqual(sMap, tMap)){
                if(minLen > right-left+1){
                    minLen = right-left+1;
                    ans = s.substring(left, right+1);
                }
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar)-1);
                left++;
            }
        }
        return ans;

    }
}