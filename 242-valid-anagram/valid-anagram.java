class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
         Map<Character,Integer> map2 = new HashMap<>();
        for(char it: s.toCharArray()){
            map1.put(it, map1.getOrDefault(it, 0) + 1);
        }
        for(char it: t.toCharArray()){
            map2.put(it, map2.getOrDefault(it, 0) + 1);
        }

        return map1.equals(map2);
        
    }
}