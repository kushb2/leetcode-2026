class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> keyToFreq = new HashMap<>();

        for(int it: nums){
            keyToFreq.put(it , keyToFreq.getOrDefault(it, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (n1,n2) -> keyToFreq.get(n1) - keyToFreq.get(n2));


        for(int it: keyToFreq.keySet()){
            heap.add(it);
            if(heap.size() > k) heap.poll();
        }

        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = heap.poll();
        }

        return ans;
       
       
    }
}