class Solution {
public:
    int majorityElement(vector<int>& nums) {
        pair<int,int> possibleMajorityElement;
        possibleMajorityElement = {nums[0], 1};
        for(int i=1;i<nums.size();i++){
            if(nums[i] != possibleMajorityElement.first){
                possibleMajorityElement.second--;
            }else{
                possibleMajorityElement.second++;
            }

            if(possibleMajorityElement.second == 0 && i < nums.size()-1){
                possibleMajorityElement = {nums[i+1], 1};
                i++;
            }
        }
        return possibleMajorityElement.first;
        
    }
};