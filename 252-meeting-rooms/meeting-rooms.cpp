class Solution {
public:
    bool canAttendMeetings(vector<vector<int>>& intervals) {
        int n = intervals.size();

        // if interval len is zero then can do all meting 
        if(n == 0) return true;
        int index = 0;
        sort(intervals.begin(), intervals.end());

        int start = intervals[index][0];
        int end = intervals[index][1];
        index++;

        while(index < n){
        int currStart = intervals[index][0];
        int currEnd = intervals[index][1];

        if(currStart < end) {// if a meeting start before the previous meeting end 
            return false;
        }

        start = currStart;
        end = currEnd;
        index++;

        }
        return true;
        
    }
};