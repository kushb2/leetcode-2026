class Solution {
    public int solve(int[] nums, int n, int idx, int target, int sum){
        if(idx == n && sum == target) return 1;
        if(idx >= n) return 0;

        int postive = solve(nums, n, idx+1,target, sum + nums[idx]);
        int negative = solve(nums, n, idx+1,target, sum - nums[idx]);

        return postive + negative;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,nums.length,0, target, 0);
        
    }
}