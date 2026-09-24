class Solution {
public:
    long long hourWithSpeed(vector<int>& piles, int speed){
        long long hour = 0;
        for(auto it: piles){
            hour += it/speed;
            hour += it%speed == 0 ? 0 : 1;
        }
        return hour;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int n = piles.size();
        
        int left = 1, right = piles[0];
        for(auto it: piles){
            right = max(right, it);
        }
        int ans = INT_MAX;
        while(left <= right){
            long long randomSpeed = left + (right - left)/2;
            long long hourNeeded = hourWithSpeed(piles, randomSpeed);

            if(hourNeeded <= h){
                ans = randomSpeed;
                right = randomSpeed-1;
            }else{
                left = randomSpeed+1;
            }
        }
        return ans;
        
    }
};