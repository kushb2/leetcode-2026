class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int ans = -1;
        while(left <= right){ // 0 1
            int mid = left + (right - left)/2; // 0
            if(nums[mid] == target){
                return mid;
            }else if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target >= nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return ans;
        
    }
}