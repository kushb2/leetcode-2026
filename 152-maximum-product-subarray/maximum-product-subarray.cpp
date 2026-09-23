class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        int maxAns = INT_MIN;
        int currAns = 1;
        for(int i=0;i<n;i++){
            currAns *= nums[i];
            maxAns = max(currAns, maxAns);
            if(currAns == 0) currAns = 1;
        }
        currAns = 1;
        for(int i=n-1;i>=0;i--){
            currAns *= nums[i];
            maxAns = max(currAns, maxAns);
            if(currAns == 0) currAns = 1;
        }

        return maxAns;

        

    }
};

