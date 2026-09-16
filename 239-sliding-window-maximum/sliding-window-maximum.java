class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];// 8 - 3 => 5
        int index = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        int left = 0, right = 0;
        while(right < k){
            int currValue = nums[right];

            while(right < k && !pq.isEmpty() && pq.peek()[1] < currValue){
                pq.poll();
            }

            pq.offer(new int[] { right, currValue}); // index and current value
            right++;
        }
        ans[index++] = pq.peek()[1];


        while(right < n){
            // remove element from left 
            while(right < n && !pq.isEmpty() && pq.peek()[0] <= left){
                pq.poll(); // remove expire element 
            }
            int currValue = nums[right];

             while(right < n && !pq.isEmpty() && pq.peek()[1] < currValue){
                pq.poll();
            }
            pq.offer(new int[] { right, currValue});
            ans[index++] = pq.peek()[1];
            left++;
            right++;

        }

        return ans;


        
    }
}