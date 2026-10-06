class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seen = new HashMap<>(); // value and index 
        int n = nums.length;
        for(int i=0;i<n;i++){
            int desiredNo = target - nums[i];
            if(seen.containsKey(desiredNo)){
                return new int[] { seen.get(desiredNo), i };
            }
            seen.put(nums[i], i);
        }
        return new int[] {};
        
    }
}