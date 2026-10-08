class Solution {
    public int solve(int[] nums,int[] dp,int n, int idx){
        if(idx >= n-1){
            return 1;
        }

        if(dp[idx] != -1) return dp[idx];

        for(int i=1;i<=nums[idx];i++){
            if(solve(nums,dp, n, idx+i) == 1){
                return dp[idx+i] = 1;
            }
        }
        return dp[idx] = 0;
    }
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int res = solve(nums,dp, nums.length, 0);
        return res == 1 ? true : false;
    }
}