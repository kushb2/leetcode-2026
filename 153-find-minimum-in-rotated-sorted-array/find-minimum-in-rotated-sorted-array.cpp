class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        int possibleAns = INT_MAX;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if(nums[left] <= nums[mid]){
                // sorted 
                possibleAns = min(possibleAns, nums[left]);
                left = mid+1;
            }else{
                possibleAns = min(possibleAns, nums[mid]);
                right = mid-1;
            }
        
        }
        return possibleAns;
        
    }
};