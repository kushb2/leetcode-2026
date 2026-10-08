
import java.lang.reflect.Array;class Solution {

    public int solve(int[] nums,int[] dp, int n, int idx){
        if(idx >= n-1){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx] && idx + i < n;i++){
           dp[idx+i] =  min = Math.min(solve(nums, dp, n, idx+i), min);
        }

        return dp[idx] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min+1;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
       
       for(int i=0;i<n;i++){
        for(int j=1;j<= nums[i] && j+i < n  ;j++){
            dp[j+i] = Math.min(dp[j+i],dp[i] + 1);
        }
       }
        
        return dp[n-1];
    }
}