class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;

        for(int i=0;i<nums.length;i++){
            if(dp[i] == false) break;
            for(int j=1;j<=nums[i] && dp[i] && i+j < nums.length;j++){
                dp[i+j] = true;
            }
        }
        return dp[nums.length-1];
    }
}