class Solution {

    int solve(int[] nums, int idx, int[] dp){
        if(idx >= nums.length-1) return 0;

        if(dp[idx] != -1) return dp[idx];

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx];i++){
           min = Math.min(min, solve(nums, idx+i, dp));
        }
        return dp[idx] = min != Integer.MAX_VALUE ? min + 1 : Integer.MAX_VALUE;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0, dp);
        
    }
}