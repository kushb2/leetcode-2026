class Solution {
    public int solve(int[] nums,int[] dp,int n, int idx){
        if(idx >= n-1){
            return 1;
        }

        if(dp[idx] != -1) return dp[idx];

        for(int i=1;i<=nums[idx];i++){
            if(solve(nums,dp, n, idx+i) == 1){
                return dp[idx+i] = 1;
            }
        }
        return dp[idx] = 0;
    }
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;

        for(int i=0;i<nums.length;i++){
            if(dp[i] == false) break;
            for(int j=1;j<=nums[i];j++){
                if(i+j > nums.length-1){
                    break;
                }
                dp[i+j] = true;
            }
        }
        return dp[nums.length-1];
    }
}