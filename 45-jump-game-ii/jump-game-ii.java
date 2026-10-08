class Solution {

    public int solve(int[] dp,int[] nums, int n, int idx){
        if(idx >= n-1) return 0;

        if(dp[idx] != -1) return dp[idx];

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx];i++){
            min = Math.min(min, solve(dp, nums, n, idx+i));
        }
        return dp[idx] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans = solve(dp, nums, nums.length, 0);
        return ans == Integer.MAX_VALUE ? Integer.MAX_VALUE : ans;
    }
}