class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<pair<int,double>> arr; // position and time to reach target
        for(int i=0;i< position.size();i++){
            double time = (double)(target - position[i])/ (double)speed[i];
            arr.push_back({position[i], time});
        }

        // sort by position 
        sort(arr.begin(), arr.end());

        stack<double> st;

        for(int i=0;i<position.size();i++){
            while(!st.empty() && st.top() <= arr[i].second){
                st.pop();
            }
            st.push(arr[i].second);
        }
        return st.size();
        
    }
};