class KthLargest {

    PriorityQueue<Integer> q = new PriorityQueue<>();
    int size;
    public KthLargest(int k, int[] nums) {
        size = k;

        for(int it: nums){
            q.offer(it);

            if(q.size() > size){
                q.poll();
            }
        }

        
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size() > size){
                q.poll();
        }
        return q.peek();

        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */