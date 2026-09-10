class Solution {
public:
    int majorityElement(vector<int>& nums) {
        pair<int,int> possibleMajorityElement;
        possibleMajorityElement = {nums[0], 1};
        for(int i=1;i<nums.size();i++){
            if(possibleMajorityElement.second == 0){
                possibleMajorityElement = {nums[i], 1};
                continue;
            }

            if(nums[i] != possibleMajorityElement.first){
                possibleMajorityElement.second--;
            }else{
                possibleMajorityElement.second++;
            }

            
        }
        return possibleMajorityElement.first;
        
    }
};