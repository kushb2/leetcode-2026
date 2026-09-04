class Solution {
public:
    void shiftArray(vector<int>& nums, int index){
        while(index<nums.size()){
            nums[index-1] = nums[index];
            index++;
        }
    }
    int removeDuplicates(vector<int>& nums) {

        int i = 1, k=0 , n = nums.size();

        while(i + k < n){ //i - convered index from starting , k index convered from end 

            if(nums[i] == nums[i-1]){
                // duplicate found 
                k++;
                shiftArray(nums, i+1);
            }else{
                i++;
            }

        }

        return i;

        
    }
};