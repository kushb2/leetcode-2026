class MyCircularQueue {
    int head; // no element 
    int tail; // no element 
    int size; // quque size 
    int[] arr; // my queue 
    int count; // current eleemnt 

    public MyCircularQueue(int k) {
        this.count = 0; // zero element in queue 
        this.arr = new int[k];
        this.size = k;
        this.head = -1;
        this.tail = -1;
    }
    
    public boolean enQueue(int value) {
        if(count == size) return false; // full 
        if(count == 0){
            head = 0;
            tail = 0;
        }else{
            tail++;
            tail = tail%size;
        }
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
        return count == size;
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