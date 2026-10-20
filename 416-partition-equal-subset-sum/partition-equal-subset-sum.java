class Solution {
    public boolean solve(int[] nums, int idx, int desiredSum,Map<String, Boolean> dp){
        if(desiredSum == 0) return true;
        if(desiredSum < 0) return false;
        if(idx < 0) return false;
        

        String key = Integer.toString(idx) + "#" + Integer.toString(desiredSum);
        if(dp.containsKey(key)) return dp.get(key);

        if(solve(nums, idx-1, desiredSum - nums[idx],dp)){
            dp.put(key, true);
            return true;
        }
        if(solve(nums, idx-1, desiredSum,dp)){
            dp.put(key, true);
            return true;
        }
        dp.put(key, false);
        return false;
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int it: nums) totalSum +=it;

        if(totalSum % 2 != 0) return false;
        Map<String, Boolean> dp = new HashMap<>();

        return solve(nums, nums.length-1,totalSum/2,dp);
        
    }
}