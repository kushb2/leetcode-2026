class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int n = position.size();
        vector<pair<int,int>> arr; // position and speed 
        for(int i=0;i<n;i++){
            arr.push_back({position[i], speed[i]});
        }
        sort(arr.begin(), arr.end()); // all line in a single line sorted by there position

        stack<pair<int,int>> st;
        for(int i=n-1;i>=0;i--){
            // can this catch a car or not 
            double currCarTime = (double)(target - arr[i].first ) / (double)arr[i].second;// how much time this car to reach at 
            // destination 
            if(!st.empty()){
                double advanceCarToReachDestination = (double)(target - st.top().first)/ (double)st.top().second;

                if(currCarTime > advanceCarToReachDestination){
                    // will not be able to catch 
                    st.push(arr[i]);
                }
            }else{
                st.push(arr[i]); // last car wait for any car for catchup to become a fleep
            }
        }

        return st.size();

        
    }
};