class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        int min = 0, idx = 0, n = arr.length;
        while(idx < n){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            char curr = arr[idx];
            while(idx < n && curr == arr[idx]){// a a a
                pq.offer(neededTime[idx]);
                idx++;
            }

            while(pq.size() > 1){
                min += pq.poll();
            }

            
            
        }
        return min;
    }
}
