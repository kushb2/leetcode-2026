class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int it: nums){
            map.put(it, map.getOrDefault(it, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );// by deafult min heap

        for(var it: map.entrySet()){
            pq.offer(new int[] { it.getValue(), it.getKey()});

            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        int idx = 0;
        while(!pq.isEmpty()){
            ans[idx++] = pq.poll()[1];
        }
        return ans;
    }
}