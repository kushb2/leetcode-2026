class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<pair<int,int>> startEndArr;
        for(auto it: intervals){
            startEndArr.push_back({it[0], it[1]});
        }

        sort(startEndArr.begin(), startEndArr.end());

        auto [prevStart, prevEnd] = startEndArr[0];
        vector<vector<int>> ans;

        for(int i=1;i<startEndArr.size();i++){
            // 8 ---- 10
            //            15 ------ 18
            auto [currStart, currEnd] = startEndArr[i];

            if(prevEnd >= currStart){
                // we can merger currMeeting is start before previous unterval end 
                prevEnd = max(prevEnd, currEnd);
            }else {
                ans.push_back({prevStart, prevEnd}); // {1,6}, {8,10}
                prevStart = currStart; // 15
                prevEnd = currEnd; // 16
            }
        }
        ans.push_back({prevStart, prevEnd});

        return ans;
        
    }
};