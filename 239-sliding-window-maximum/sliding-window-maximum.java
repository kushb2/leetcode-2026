class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int left = 0, right = 0;

        while(right < k){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast(); // if existing number is lees 
                // then nums[right] they will never be part of ans 
            }
            dq.addLast(right);
            right++;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(right < n){
            // answer for current window
            ans.add(nums[dq.peekFirst()]);
            left++;
            // remove exired element 
            while(!dq.isEmpty() && dq.peekFirst() < left){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast(); // if existing number is lees 
                // then nums[right] they will never be part of ans 
            }
            dq.addLast(right);            
            right++;
        }
         // last window
        ans.add(nums[dq.peekFirst()]);

        return ans.stream().mapToInt(i -> i).toArray();

    }
}