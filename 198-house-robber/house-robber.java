class Solution {
    int max;
    public int solve(int[] dp, int[] nums, int n, int idx){
        if(idx >= n) return 0;

        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + solve(dp, nums, n , idx+2);
        int skip = solve(dp, nums, n, idx+1);

        return dp[idx] = Math.max(pick, skip);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(dp, nums, nums.length, 0);        
    }
}