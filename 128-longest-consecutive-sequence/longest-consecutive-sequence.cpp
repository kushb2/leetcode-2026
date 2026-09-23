class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if(nums.size() == 0) return 0; 
        set<int> set;
        for(auto it: nums) set.insert(it);
        vector<int> nums2;
        for(auto it: set) nums2.push_back(it);
        int n = nums2.size(); int i = 0;
        int maxLen = 1;
        while(i < n){ // 0
            int currLen = 1;
            i++; // 1
            // 1 2 3 4 100 200
            while(i < n && nums2[i] == nums2[i-1]+1) {
                i++;// 4
                currLen++;//4
            }
            maxLen = max(currLen, maxLen);
        }
        
        return maxLen;
    }
};

// [100,4,200,1,3,2]
// 1 2 3 4 100 200 

// i < n 
// len = 1 
// i+1 < n => len ++
// max ans 
// start again 
