class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        for(auto it: nums) map[it]++;

        priority_queue<pair<int,int>,
         vector<pair<int,int>>,
         greater<pair<int,int>>
         
         > pq; // by default max queue, convert to min

        for(auto [key, freq]: map){
            pq.push({freq,key});

            if(pq.size() > k) pq.pop();
        }
        vector<int> ans;
        while (!pq.empty()) {
            ans.push_back(pq.top().second);
            pq.pop();
        }
        return ans;
    }
};