class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> dq = new ArrayDeque<>();
       int[] ans = new int[nums.length - k + 1];
        int idx = 0;
       int right = 0; 
       for(; right<k;right++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]){
                dq.pollLast();
            }
            dq.addLast(right);
       }
       ans[idx++] = nums[dq.getFirst()];

       for(; right< nums.length;right++){
            // add new element
            while(!dq.isEmpty() && dq.getFirst() <= right - k){ /// 1 2
                dq.pollFirst();
            }
            

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]){
                dq.pollLast();
            }
            dq.addLast(right);

            ans[idx++] = nums[dq.getFirst()];

       }
       return ans;


        
    }
}

