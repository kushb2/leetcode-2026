class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        vector<pair<int,int>> peopleList;
        for(int i=0;i<people.size();i++){
            peopleList.push_back({people[i], i});
        }

        sort(flowers.begin(), flowers.end());

        // sort people , idea if an interval invalid ith index it will invalid for i+1... 
        sort(peopleList.begin(), peopleList.end());

        priority_queue<int, vector<int>, greater<int>> pq; // need min heap as on top least end time 

        int right = 0; // process interval 
        vector<int> ans(people.size());

        for(auto[key, index]: peopleList){ // for each people find how many flower he will see 

            // add all valid interval which start bomming before he arrive
            while(right < flowers.size() && flowers[right][0] <= key){
                pq.push(flowers[right][1]);
                right++;
            }

            // remove expired one which stop blooming 
            while(!pq.empty() && pq.top() < key){
                pq.pop();
            }

            ans[index] = pq.size();
        }

        return ans;

        
    }
};