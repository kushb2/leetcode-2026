class Solution {
     public int solve(int[] nums,int n, int idx, int nextIndex,int[][] dp){

        if(idx < 0) return 0;

        if(dp[idx][nextIndex] != -1) return dp[idx][nextIndex];

        if(nextIndex == n || nums[nextIndex] > nums[idx]){
            int take = 1 + solve(nums,n,idx-1, idx,dp);
            int skip = solve(nums, n, idx-1, nextIndex,dp);
            return dp[idx][nextIndex] = Math.max(take, skip);
        }else{
            int skip = solve(nums, n, idx-1, nextIndex,dp);
            return dp[idx][nextIndex] = skip;
        }

    }

    public int lengthOfLIS(int[] nums) {
         int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n+1][n+1]; 
        for(int[] it: dp) Arrays.fill(it,-1);
        return solve(nums, n, n-1, n, dp);
        
    }
}