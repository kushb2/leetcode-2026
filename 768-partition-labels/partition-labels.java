class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> lst = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(s.charAt(i), i);// chat to last index 

        int needToGo = -1;
        int prevSplit = -1;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            needToGo = Math.max(needToGo, map.get(c));

            if(i == needToGo){
                lst.add(i - prevSplit);
                prevSplit = i;
                needToGo = -1;
            }
        }

        return lst;

        
        
    }
}
