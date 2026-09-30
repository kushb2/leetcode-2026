class KthLargest {
    PriorityQueue<Integer> pq;
    int size;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.size = k;
        for(int it: nums) {
            pq.offer(it);

            if(pq.size() > size){
                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
        pq.offer(val);

        if(pq.size() > size){
            pq.poll();
        }
        return pq.peek();
    
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 // 8 5 4