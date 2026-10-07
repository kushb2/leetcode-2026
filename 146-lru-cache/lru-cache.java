class LRUCache {
    class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

    }
    Map<Integer,ListNode> map; // key to node in list list 
    int capacity; // size of cache 
    ListNode head, tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    void deleteNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;

    }

    void addNode(ListNode node){
        ListNode prev = head;
        ListNode next = head.next;

        prev.next = node;
        node.prev = prev;

        node.next = next;
        next.prev = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1; // key does not exist 
        ListNode node = map.get(key);
        deleteNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteNode(map.get(key));
            map.remove(key);
        }else if(capacity == map.size()){
            // remove from tail 
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        } 

        ListNode node = new ListNode(key, value);
        addNode(node);
        map.put(key, node);

        // for(var x : map.entrySet()){
        //     System.out.println(x.getKey() + " " + x.getValue().value);
        // }
        // System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */