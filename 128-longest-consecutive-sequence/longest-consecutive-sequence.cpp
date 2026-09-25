class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        sort(nums.begin(), nums.end());
        int ans = 1; // a single interger will satify condition 
        int count = 1; // local len for a valid substring 

        for(int i=1;i<nums.size();i++){
            
            if(nums[i-1] == nums[i]) continue;
            if(nums[i-1]+1 == nums[i]){ //1 - 2 
                count++;
            }else{ 
                ans = max(ans, count);
                count = 1;
            }
        }
        return max(ans, count);
        
    }
};