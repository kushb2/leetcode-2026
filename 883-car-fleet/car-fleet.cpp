class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int n = position.size();
        vector<pair<int,double>> arr; // position and (speed, time to reach destination) 
        for(int i=0;i<n;i++){
            double timeToReachDestination = (double)(target - position[i] ) / (double)speed[i];// how much time this car to reach at 
            arr.push_back( {position[i], timeToReachDestination});
        }
        sort(arr.begin(), arr.end()); // all line in a single line sorted by there position

        stack<pair<int,double>> st;
        for(int i=n-1;i>=0;i--){
            
            if(!st.empty() && arr[i].second <= st.top().second){
                // do nothing
            }else{
                st.push(arr[i]);
            }
            
        }

        return st.size();

        
    }
};