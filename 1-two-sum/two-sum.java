class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // key and index 

        for(int i=0;i<nums.length;i++){
            int desired = target - nums[i]; // i + j = target =
            if(map.containsKey(desired)){
                return new int[] { map.get(desired), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
        
    }
}