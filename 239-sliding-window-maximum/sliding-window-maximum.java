class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int index = 0;
        int[] ans = new int[n-k+1];
        Deque<int[]> dq = new ArrayDeque<>();

        while(right < k){
            int currValue = nums[right];
            while(!dq.isEmpty() && dq.getLast()[1] < currValue){
                dq.pollLast();
            } 

            dq.addLast(new int[] { right , currValue });// index value 
            right++;
        }

        ans[index++] = dq.peekFirst()[1];// 3

        while(right < n){
            int currValue = nums[right];

            while(!dq.isEmpty() && dq.getFirst()[0] <= left){ // 3 -1 -3
                dq.pollFirst();
            }

            while(!dq.isEmpty() && dq.getLast()[1] < currValue){
                dq.pollLast();
            }
            dq.addLast(new int[] { right , currValue });// index value 
            ans[index++] = dq.peekFirst()[1];
            right++;
            left++;



        }
        return ans;




        
    }
}