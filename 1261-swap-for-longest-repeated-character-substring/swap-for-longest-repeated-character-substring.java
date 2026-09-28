class Solution {
    public int maxRepOpt1(String text) {
        Map<Character,Integer> map = new HashMap<>();

        char[] arr = text.toCharArray();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            // starting char of a valid substring 
            char c = arr[i];
            int diffCount = 0;
            int sameCount = 0;
            for(int j=i;j<arr.length;j++){
                if(arr[j] != c){
                    diffCount++;
                }else{
                    sameCount++;
                }
                if(diffCount > 1) break;

                if(sameCount < map.get(c) || diffCount == 0){
                    ans = Math.max(j-i+1, ans);
                }
                
            }

        }
        return ans;
        
    }
}