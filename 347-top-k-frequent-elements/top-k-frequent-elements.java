class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> keyToFreq = new HashMap<>();

        for(int it: nums){
            keyToFreq.put(it , keyToFreq.getOrDefault(it, 0) + 1);
        }

        Queue<int[]> heap = new PriorityQueue<>(
            (n1,n2) -> n1[1] - n2[1]);


        for(var it: keyToFreq.entrySet()){
            heap.add(new int[] { it.getKey(), it.getValue()});
            if(heap.size() > k) heap.poll();
        }

        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = heap.poll()[0];
        }

        return ans;
       
       
    }
}