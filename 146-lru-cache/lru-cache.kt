class DoublyLinkList(val key: Int, val value: Int, var prev: DoublyLinkList?, var next: DoublyLinkList?)

val  head: DoublyLinkList = DoublyLinkList(-1,-1, null, null);
val tail: DoublyLinkList =  DoublyLinkList(-1,-1, null, null);



var capacity: Int = 0;


class LRUCache(limit: Int) {

     init {
        head.next = tail;
        tail.prev = head;
        capacity = limit;
    }

    
    
    val map: MutableMap<Int, DoublyLinkList> = mutableMapOf();


       // LRU most recently head -> 4 -> 1 -> 2 -> 3 ->  5 -> tail least recently
    fun removeNode(node: DoublyLinkList) {
        val prev: DoublyLinkList  = node.prev!!;
        val next: DoublyLinkList = node.next!!;
        prev.next = next;
        next.prev = prev;
    }

    fun addNode(node: DoublyLinkList) {
        val prev: DoublyLinkList = head;
        val next: DoublyLinkList = head.next!!;

        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;

    }    

    fun get(key: Int): Int {
         if(!map.containsKey(key)) return -1;
        val node = map.get(key)!!;
        removeNode(node);
        addNode(node);
        return node.value;
    }

    fun put(key: Int, value: Int) {
        if(map.containsKey(key)) {
             val node = map.get(key)!!;
             removeNode(node);
             map.remove(key);
             // update value 
         }else if(map.size == capacity){
             val lruNode: DoublyLinkList = tail.prev!!;
             val key = map.get(lruNode.key)!!.key;
             removeNode(lruNode);
             map.remove(key);
             // cache is full
             // remove least recetly used key 
         }
        val newNode = DoublyLinkList(key, value, null, null);
        addNode(newNode);
        map[key] = newNode;
        // basically add this key value pair 
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */