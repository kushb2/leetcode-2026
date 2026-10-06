class Solution {
    public int solve(int[] nums, int idx, int[] dp){
        if(idx >= nums.length-1) return 1;

        if(dp[idx] != -1) return dp[idx];

        for(int i=1;i <= nums[idx];i++){
            if(solve(nums, idx+i, dp) == 1){
                return dp[idx] = 1;
            }
        }

        return dp[idx] = 0;


    }

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans = solve(nums, 0, dp);
        return ans == 1 ? true : false;
    }
}

