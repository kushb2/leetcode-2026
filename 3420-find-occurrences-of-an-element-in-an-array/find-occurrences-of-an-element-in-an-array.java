class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> occurence = new ArrayList<>();
        for(int i=0;i<nums.length;i++) 
            if(nums[i] == x) 
                occurence.add(i);

        int[] ans = new int[queries.length];
        int idx = 0;
        for(int it: queries){
            System.out.println(it + " " + occurence.size());
            ans[idx++] = it > occurence.size() ? -1 : occurence.get(it-1);
        }
        return ans;        
    }
}