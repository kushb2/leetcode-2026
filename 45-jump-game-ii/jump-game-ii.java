class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

       for(int i=0;i<n;i++){
        for(int j=1;j<=nums[i];j++){
            if(i+j >= n) break;
            if(dp[i+j] == Integer.MAX_VALUE) {
                 dp[i+j] = 1 + dp[i];
            } 
        }
       }
        return dp[nums.length-1];
        
    }
}