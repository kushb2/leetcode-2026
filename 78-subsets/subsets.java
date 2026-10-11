class Solution {

    public void solve(int[] nums, int n, int idx, List<List<Integer>> res, List<Integer> curr){
        if(idx == n){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        solve(nums, n, idx+1, res, curr);
        curr.remove(curr.size()-1);
        solve(nums, n, idx+1, res, curr);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(nums, nums.length, 0, res, curr);
        return res;
        
    }
}