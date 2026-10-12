class Solution {
    public int getCount(int[] nums, int targetSum){ // 15 2
        int split = 1, currentSum = 0;
        for(int it: nums){ // [7,2,5,10,8]
            if(currentSum + it > targetSum){
                split++;
                currentSum = it;
            }else{
                currentSum += it;
            }
        }
        return split;
    }
    public int splitArray(int[] nums, int k) {
        int left = -1, right = 0;
        for(int it: nums){
            left = Math.max(left, it);
            right += it;
        }
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            // maximise each split sum as mid 
            int splitCount = getCount(nums, mid);

            if(splitCount <= k){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }

        }

        return ans;

        
    }
}

// Input: nums = [7,2,5,10,8], k = 2
// 7,2,5 10,8 => 18 Ans 