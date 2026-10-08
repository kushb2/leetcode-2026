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
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length]; // when i am no index i , how much max i can have 
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[nums.length-1];
    }
}