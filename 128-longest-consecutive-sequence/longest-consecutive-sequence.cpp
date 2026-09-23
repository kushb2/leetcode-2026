class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if(nums.size() == 0) return 0; 
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int maxLen = 1;
        int currLen = 1;
        for(int i=1;i<n;i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    currLen++;
                }else{
                    maxLen = max(maxLen, currLen);
                    currLen = 1;
                }
            }
        }
        
        return max(maxLen, currLen);
    }
};

// [100,4,200,1,3,2]
// 1 2 3 4 100 200 

// i < n 
// len = 1 
// i+1 < n => len ++
// max ans 
// start again 
