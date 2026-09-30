class MedianFinder {
    PriorityQueue<Integer> maxHeap; // first part
    PriorityQueue<Integer> minHeap; // second part

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a,b) -> b-a);
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }

        if(minHeap.size() > maxHeap.size()+1){
            maxHeap.offer(minHeap.poll());
        }

        
        
    }
    
    public double findMedian() {
         if(maxHeap.size() == minHeap.size()){
            return ((double)maxHeap.peek() + minHeap.peek())/2;
        }else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }else{
            return minHeap.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */