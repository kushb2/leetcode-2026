class Solution {

    public int solve(int[] nums,int targetSum, int n,int[][] dp){
    if(targetSum == 0){
        return 1;
    }

    // if (targetSum < 0) return 0;
        
    if(n < 0) return 0;

    if(dp[n][targetSum] != -1) return dp[n][targetSum];

    int pick = nums[n] > targetSum ? 0 : solve(nums, targetSum - nums[n], n-1,dp);
    int skip = solve(nums, targetSum, n-1,dp);

    return dp[n][targetSum] = ((pick==1) || (skip==1)) ? 1 : 0;

    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int it: nums){
            sum += it;
        }
        if(sum % 2 != 0) return false;

        int[][] dp = new int[nums.length][sum/2+1];
        for(int[] it: dp) Arrays.fill(it, -1);

        int ans = solve(nums,sum/2, nums.length-1, dp);
        return ans == 0 ? false : true;
    }
}