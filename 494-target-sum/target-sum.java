class Solution {
    public int solve(int[] nums, int n, int idx, int target, int sum){
        // as we need to element of nums , so terminal condition is idx == n 
        // then we check if sum == target we found on combination 
        if(idx == n && sum == target) return 1;

        // i can no longer pick any nums , my iteration is complete will not find any ans now 
        if(idx >= n) return 0;

        int postive = solve(nums, n, idx+1,target, sum + nums[idx]);
        int negative = solve(nums, n, idx+1,target, sum - nums[idx]);

        return postive + negative;
    }

     // two variable are changing my sum and idx , so i need 2d DP 
     // what is maximum value of sum , sum of all nums 
     public int solveDp(int[] nums, int n, int idx, int target, int sum, int[][] dp){
        // as we need to element of nums , so terminal condition is idx == n 
        // then we check if sum == target we found on combination 
        if(idx == n && sum == target) return 1;

        // i can no longer pick any nums , my iteration is complete will not find any ans now 
        if(idx >= n) return 0;

        if(dp[idx][sum] != -1) return dp[idx][sum];

        int postive = solve(nums, n, idx+1,target, sum + nums[idx]);
        int negative = solve(nums, n, idx+1,target, sum - nums[idx]);

        return dp[idx][sum] = postive + negative;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i: nums) sum += i;
        int[][] dp = new int[nums.length][sum+1];
        for(int[] it: dp) Arrays.fill(it, -1);
        return solveDp(nums,nums.length,0, target, 0, dp);
    }
}