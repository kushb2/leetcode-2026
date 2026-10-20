class Solution {
    public int solve(int[] nums, int idx, int desiredSum,int[][] dp){
        if(desiredSum == 0) return 1;
        if(desiredSum < 0) return 0;
        if(idx < 0) return 0;
        

        if(dp[idx][desiredSum] != -1 ) return dp[idx][desiredSum];

        if(solve(nums, idx-1, desiredSum - nums[idx],dp) == 1){
            dp[idx][desiredSum] = 1;
            return 1;
        }
        if(solve(nums, idx-1, desiredSum,dp) == 1){
            dp[idx][desiredSum] = 1;
            return 1;
        }
        dp[idx][desiredSum] = 0;
        return 0;
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int it: nums) totalSum +=it;

        if(totalSum % 2 != 0) return false;
        int[][] dp = new int[nums.length][totalSum/2+1];
        for(int[] it: dp) Arrays.fill(it, -1);

        return solve(nums, nums.length-1,totalSum/2,dp) == 0 ? false : true;
        
    }
}