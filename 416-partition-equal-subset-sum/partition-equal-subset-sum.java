class Solution {

    public int solve(int[] nums,int targetSum, int n, int idx, int currSum,int[][] dp){
        if(n == idx){
            return targetSum == currSum ? 1 : 0;
        }

        if(currSum == targetSum) return 1;
        if (currSum > targetSum) return 0;

        if(dp[idx][currSum] != -1) return dp[idx][currSum];

        int pick = solve(nums, targetSum, n, idx+1, currSum + nums[idx],dp);
        int skip = solve(nums, targetSum, n, idx+1, currSum,dp);

        return dp[idx][currSum] = ((pick==1) || (skip==1)) ? 1 : 0;

    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int it: nums){
            sum += it;
        }
        if(sum % 2 != 0) return false;

        int[][] dp = new int[nums.length][sum+1];
        for(int[] it: dp) Arrays.fill(it, -1);


        int ans = solve(nums,sum/2, nums.length, 0, 0, dp);
        return ans == 0 ? false : true;
    }
}