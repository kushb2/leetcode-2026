class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        // for each index i , first i want to say have i seen this number 
        // before if yes then give me most recent occurence 
        // will check abs(i - j) <= k then return true
        // if i do not find any such index after iterating complete array 
        // i will return false 
        
        unordered_map<int,int> map; // element and its recent index 

        for(int i=0;i<nums.size();i++){
            int it = nums[i];
            if(map.contains(it) &&  i - map[it] <= k) return true;
            map[it] = i;
        }

        return false;
    }
};