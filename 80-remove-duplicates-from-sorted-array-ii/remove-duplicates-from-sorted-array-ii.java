class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0, right =0;
        while(right < n){
            int it = nums[right];
            int count = 0;
            while(right<n && it == nums[right]){
                count++;
                if(count < 3){
                    nums[left] = nums[right];
                    left++;
                }
                 right++;
            }
        }
        return left;
    }
}