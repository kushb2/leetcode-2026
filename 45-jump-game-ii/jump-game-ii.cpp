class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        vector<int> minStep(n, INT_MAX); // each index i will store minimum step to reach at this index

        minStep[0] = 0;
        int j=0;
        for(int i=1;i<n;i++){
            // can i reach here from previous index 
            for(; j<i;j++){
                if(j + nums[j] >= i){ // can reach
                    minStep[i] = min(minStep[i], minStep[j] + 1);
                    break;
                }
            }
        }

        return minStep[n-1];
        
    }
};