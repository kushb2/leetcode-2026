class Solution {
    public boolean same(Map<Character, Integer> map1, Map<Character, Integer> map2){
        for(var it: map1.entrySet()){
            if(!map2.containsKey(it.getKey())) return false;
            if(map2.get(it.getKey()) < it.getValue()) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr =  t.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();// t map
        Map<Character, Integer> map2 = new HashMap<>();
        for(char it: tArr){
            map1.put(it, map1.getOrDefault(it, 0)+1);
        }

        int left = 0, ans = Integer.MAX_VALUE;
        int start=0, end=0;
        int matched = 0;
        for(int right = 0;right < sArr.length;right++){
            map2.put(sArr[right], map2.getOrDefault(sArr[right], 0)+1);
            if(map1.containsKey(sArr[right]) 
            && map1.get(sArr[right]).equals(map2.get(sArr[right]))){
                matched++;
            }

            while(matched == map1.size()){
                if((right-left+1) < ans){
                    ans = Math.min(right-left+1, ans);  
                    start = left; end = right;
                }
                map2.put(sArr[left], map2.getOrDefault(sArr[left], 0)-1);
               // FIX: Check lChar, and only decrement if count drops strictly below target requirement
                if (map1.containsKey(sArr[left]) && map2.get(sArr[left]) < map1.get(sArr[left])) {
                    matched--;
                }
                left++;
               
            
            }

        }

        if(ans == Integer.MAX_VALUE) return "";

        StringBuilder sb = new StringBuilder();
        for(int i= start; i<= end;i++){
            sb.append(sArr[i]);
        }
        return new String(sb);


    }
}