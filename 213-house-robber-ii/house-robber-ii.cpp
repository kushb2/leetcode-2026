class Solution {
public:
    int maxProfit(vector<int>& nums, int start, int end, int n){
        vector<int> dp(n);// 1 2
        dp[start] = nums[start];
        dp[start+1] = max(nums[start], nums[start+1]);
        start +=2;
        while(start<=end){
            dp[start] = max(nums[start]+ dp[start-2], dp[start-1]);
            start++;
        }
        return dp[end];
    }
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return nums[0];
        if(n == 2) return max(nums[0], nums[1]);
        return max(maxProfit(nums, 0, n-2,n) , maxProfit(nums, 1, n-1,n));

        
    }
};