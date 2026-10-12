class Solution {
    public int calDays(int[] weights, int targetWeight){
        int currWeight = 0, days = 1;
        for(int it: weights){
            if(currWeight + it > targetWeight){
                days++;
                currWeight = 0;
            }
            currWeight += it;
            
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int it: weights){
            left = Math.max(left, it);
            right += it;
        }
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2; // try with this weight

            int daysNeeded = calDays(weights,mid);
            System.out.println(mid + " " + daysNeeded);

            if(daysNeeded <= days){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return ans;

        
    }
}
// [1,2,3,4] [5,6] [7][8][9][10]

