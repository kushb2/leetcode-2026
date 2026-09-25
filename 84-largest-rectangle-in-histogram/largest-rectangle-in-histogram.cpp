class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        // for each index i will ask for this index height to be part of ans
        // i want left and right first min min than this so i know this can streat to this level
        vector<int> arrL(n), arrR(n);
        stack<int> stL, stR;

        for(int i=0;i<n;i++){
            while(!stL.empty() && heights[i] <= heights[stL.top()]){ // 5 < 4
                // stL can never part of ans 
                stL.pop();
            }

            arrL[i] = stL.empty() ? -1 : stL.top();
            stL.push(i);
        }
        for(int i=n-1;i>=0;i--){
            while(!stR.empty() && heights[i] <= heights[stR.top()]){ // 5 < 4
                // stL can never part of ans 
                stR.pop();
            }

            arrR[i] = stR.empty() ? n : stR.top();
            stR.push(i);
        }
        int ans = 0;
        for(int i=0;i<n;i++){ // -1 to 5 => 6
            cout<<arrL[i]<<" "<<arrR[i]<<endl;
            int area = (arrR[i] - arrL[i] - 1) * heights[i];
            ans = max(area, ans);

        }
        return ans;
        
    }
};