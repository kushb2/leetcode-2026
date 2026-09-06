class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int nextUniqueElement = 1;

        for(int i=1;i<nums.size();i++){
            if(nums[i] != nums[i-1]){
                // duplicate element found 
                // move to next unique element space
                nums[nextUniqueElement] = nums[i];
                nextUniqueElement++;
            }
        }

        return nextUniqueElement;
        // 1 1 2 
        // 1 [2]- next  2
        
    }
};