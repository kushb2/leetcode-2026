class Solution {

    public int solve(int[] nums,int targetSum, int n,int[][] dp){
    if(targetSum == 0){
        return 1;
    }
        
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

        boolean[][] dp = new boolean[nums.length][sum/2+1]; // index to sum 
        for(boolean[] it: dp) Arrays.fill(it, false);
        int n = nums.length;

        for(int i=0;i<n;i++){
            dp[i][0] = true; // to make sum 0 is always possible 
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=sum/2;j++){

                boolean take = false;
                if(j >= nums[i]){
                    take = dp[i-1][j - nums[i]];
                }
                boolean skip = dp[i-1][j];
                dp[i][j] = take || skip;
            }
        }

        return dp[n-1][sum/2];

    }
}