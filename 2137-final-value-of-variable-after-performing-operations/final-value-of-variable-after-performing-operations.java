class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String it: operations){
            if(it.equals("++X") || it.equals("X++")){
                ans++;
            }else{
                ans--;
            }
        }
        return ans;
        
    }
}