class Solution {
public:
    bool comp(vector<int> a , vector<int> b){
        return a[0] < b[0];
    }
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        // first sort the queries 
        vector<pair<int, int>> queryList;
        for(int i=0;i<queries.size();i++){
            queryList.push_back({queries[i], i});
        }
        sort(queryList.begin(), queryList.end());

        // sort the interval by start 
        sort(intervals.begin(), intervals.end(), [](vector<int> a , vector<int> b) {
             return a[0] < b[0];
        });

        // create a min heap 
        priority_queue<
        pair<int, int>,
        vector<pair<int, int>>,
        greater<pair<int,int>>
        > pq;
        int right = 0;
        vector<int> ans(queries.size());
        for(auto [key,index] : queryList){
            while(right < intervals.size() && intervals[right][0] <= key){ // all valid interval added 
                // can be valid ans add to the heap 
                pq.push({intervals[right][1] - intervals[right][0] + 1, intervals[right][1]});
                right++;
            }

            while(!pq.empty() && pq.top().second < key){ // expired 
                pq.pop();
            }


            ans[index] = pq.empty() ? -1 : pq.top().first;

        }

        return ans;

       
    }
};