class MyCircularQueue {
    int[] arr;
    int count;
    int head, tail;
    int size;

    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.count = 0;
        this.head =  0;
        this.tail =  -1;
        this.size = k;
        
    }
    
    public boolean enQueue(int value) {
        if(size == count) return false;
        tail++;
        tail = tail % size;
        
        
        arr[tail] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count == 0) return false;
        head++;
        head = head % size;
        count--;
        return true;
        
    }
    
    public int Front() {
        if(count == 0) return -1;
        return arr[head];
        
    }
    
    public int Rear() {
        if(count == 0) return -1;
        return arr[tail];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return size == count;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */