class Solution {
    public boolean same( Map<Character,Integer> map1,  Map<Character,Integer> map2){
        for(var it: map1.keySet()){
            if(!map2.containsKey(it)) return false;
            if(!map2.get(it).equals(map1.get(it))) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n1 > n2) return false;


        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();


        for(char it: arr1){
            map1.put(it, map1.getOrDefault(it, 0)+1);
        }
        for(int i=0;i< n1;i++){
            map2.put(arr2[i],  map2.getOrDefault(arr2[i], 0)+1);
        }

        if(same(map1, map2)) return true;
        int left = 0;
        
        // eidbaooo start with d ?
        for(int right = n1;right < s2.length();right++){
            map2.put(arr2[right],  map2.getOrDefault(arr2[right], 0)+1);
            map2.put(arr2[left],  map2.getOrDefault(arr2[left], 0)-1);
            if(map2.get(arr2[left]) == 0) map2.remove(arr2[left]);
            left++;
            if(same(map1, map2)) return true;
        } 
        return false;

        
    }
}