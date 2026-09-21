class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> ans;
        bool operationDone = false;
        int i=0;
        for(;i<intervals.size();i++){

            int start = intervals[i][0];
            int end = intervals[i][1];

            int newStart = newInterval[0];
            int newEnd = newInterval[1];

            // can i insert new interval
            // if newEnd before start 
            if(newEnd < start){
                ans.push_back(newInterval);
                operationDone = true;
                break;
            }

            // can i merge 
            if(newStart <= end){
                // new interval start before curr end 
                newInterval = {
                    min(newStart, start),
                    max(newEnd, end)
                };
            }else{
                ans.push_back(intervals[i]);
            }
        }
        while(i < intervals.size()){
            ans.push_back(intervals[i]);
            i++;
        }

        if(!operationDone){
            ans.push_back(newInterval);
        }
        return ans;
    }
};