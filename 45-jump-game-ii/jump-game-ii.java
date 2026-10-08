class Solution {

    public int solve(int[] nums,int[] dp, int n, int idx){
        if(idx >= n-1){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx];i++){
            min = Math.min(solve(nums, dp, n, idx+i), min);
        }

        return dp[idx] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min+1;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums,dp, n, 0);
    }
}