class Solution {
public:
    vector<vector<int>> findSum(vector<int>& nums, int left, int right, int first) {
        vector<vector<int>> ans;
        while(left < right){
            int sum = nums[left] + nums[right] + nums[first];
            if(sum == 0){
                ans.push_back({nums[first], nums[left], nums[right]});
                left++; right--;
                while(left<right && nums[left] == nums[left-1]) left++;
            }else if(sum > 0){
                right--;
            }else{
                left++;
            }

        }
        return ans;
    }
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        int n = nums.size();
        for(int i=0;i<n-2;i++){ // [-1,0,1,2,-1,-4] n = 6 , 
            if(i > 0 && nums[i-1] == nums[i]) continue;
            vector<vector<int>> sum = findSum(nums, i+1, n-1, i);
            for(auto it: sum){
                ans.push_back(it);
            }
        }
        return ans;
    }
};