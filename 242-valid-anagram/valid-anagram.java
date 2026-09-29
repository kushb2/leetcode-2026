class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char it: s.toCharArray()){
            map.put(it, map.getOrDefault(it, 0)+1);
        }

        for(char it: t.toCharArray()){
            map.put(it, map.getOrDefault(it, 0) - 1);
        }

        for(var it: map.entrySet()){
            if(it.getValue() != 0) return false;
        }
        return true;
    }
}