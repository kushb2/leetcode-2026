class Solution {
public:
    static bool comp(const pair<int,int> &a, const pair<int,int> &b){
        return a.first < b.first;
    }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<pair<int,int>> arr;
        for(auto it: intervals){
            arr.push_back({it[0], it[1]}); // start end 
        }

        sort(arr.begin(), arr.end(), comp);

        int s = arr[0].first;
        int e = arr[0].second;

        vector<vector<int>> ans;

        for(int i=1;i<arr.size();i++){

            // if this interval start before previous interval end we can merge it 
            int s2 = arr[i].first;
            int e2 = arr[i].second;
            if(s2 <= e) {
                // can merge 
                s = min(s, s2);
                e = max(e,e2);
            }else{
                ans.push_back({s,e});
                s = s2;
                e = e2;
                // can not merge 
            }

        }

        ans.push_back({s,e});
        return ans;
        
    }
};