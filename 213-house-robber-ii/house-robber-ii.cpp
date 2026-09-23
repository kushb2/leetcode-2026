class Solution {
public:
    int maxProfit(vector<int>& nums, int start, int end, int n){
       int first = nums[start], second = max(nums[start], nums[start+1]);
       start +=2;
        while(start<=end){
            int temp = second;
            second = max(nums[start]+ first, second);
            first = temp;
            start++;
        }
        return second;
    }
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return nums[0];
        if(n == 2) return max(nums[0], nums[1]);
        return max(maxProfit(nums, 0, n-2,n) , maxProfit(nums, 1, n-1,n));

        
    }
};