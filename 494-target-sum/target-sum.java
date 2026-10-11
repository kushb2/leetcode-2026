class Solution {
    public int solve(int[] nums, int n, int idx, int target, int sum){
        // as we need to element of nums , so terminal condition is idx == n 
        // then we check if sum == target we found on combination 
        if(idx == n && sum == target) return 1;

        // i can no longer pick any nums , my iteration is complete will not find any ans now 
        if(idx >= n) return 0;

        int postive = solve(nums, n, idx+1,target, sum + nums[idx]);
        int negative = solve(nums, n, idx+1,target, sum - nums[idx]);

        return postive + negative;
    }

     // two variable are changing my sum and idx , so i need 2d DP 
     // what is maximum value of sum , sum of all nums 
     public int solveDp(int[] nums, int n, int idx, int target, int sum, Map<String, Integer> map){
        // as we need to element of nums , so terminal condition is idx == n 
        // then we check if sum == target we found on combination 
        if(idx == n){
            return sum == target ? 1 : 0;
        }

        // i can no longer pick any nums , my iteration is complete will not find any ans now 
        if(idx >= n) return 0;
        String key = Integer.toString(idx) + "#" + Integer.toString(sum);
        if(map.containsKey(key)) return map.get(key);

        int postive = solveDp(nums, n, idx+1,target, sum + nums[idx], map);
        int negative = solveDp(nums, n, idx+1,target, sum - nums[idx], map);

         map.put(key, postive + negative);
         return postive + negative;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return solveDp(nums,nums.length,0, target, 0, map);
    }
}