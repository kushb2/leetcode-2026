
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String it: strs){
            char[] arr = it.toCharArray();
            Arrays.sort(arr);
            String sortedIt = new String(arr);
            map.putIfAbsent(sortedIt, new ArrayList<>());
            map.get(sortedIt).add(it);
        }
        List<List<String>> ans = new ArrayList<>();
        for(var it: map.entrySet()){
            ans.add(it.getValue());
        }
        return ans;
        
    }
}