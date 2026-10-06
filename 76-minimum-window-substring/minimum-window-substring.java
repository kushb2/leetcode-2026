class Solution {
    public boolean validSubString(Map<Character, Integer> map1, Map<Character, Integer>  map2){
        for(var it: map2.entrySet()){
            if(!map1.containsKey(it.getKey())) return false;
            if(map1.get(it.getKey()) < it.getValue()) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> map1, map2; // char and freq
        map1 = new HashMap<>(); map2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, ans = Integer.MAX_VALUE, minLeft = 0, minRight = 0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            map1.put(c, map1.getOrDefault(c, 0) + 1);



            while(validSubString(map1, map2)){
                if(ans > right-left+1){
                    ans = Math.min(ans, right-left+1);
                    minLeft = left;
                    minRight = right;
                }
                map1.put(s.charAt(left), map1.get(s.charAt(left)) - 1);
                left++;
            }

        }

        return ans == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight+1);
    

    }
}