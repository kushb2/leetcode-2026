class LRUCache {
public:
    class DoublyListList {
        public:
        int key, value;
        DoublyListList *prev, *next;

        DoublyListList(int k, int v){
            key = k;
            value = v;
            prev = next = nullptr;
        }

    };
    int limit = 0;
    DoublyListList *head = new DoublyListList(-1,-1);
    DoublyListList* tail = new DoublyListList(-1,-1);

    unordered_map<int, DoublyListList*> map;

    void addNode(DoublyListList* node){
        // head node tail/next 
        DoublyListList* prev = head;
        DoublyListList* next = head->next;

        prev->next = node;
        node->prev = prev;
        node->next = next;
        next->prev = node;

    }

    void remove(DoublyListList* node){
        // prev node next
        DoublyListList* prev = node->prev;
        DoublyListList* next = node->next;
        prev->next = next;
        next->prev = prev;
    }

    LRUCache(int capacity) {
        limit = capacity;
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        if(!map.contains(key)) return -1;

        DoublyListList *node = new DoublyListList(key, map[key]->value);
        remove(map[key]);
        map.erase(key);

        addNode(node);
        map[key] = node;

        return node->value;
        
    }
    
    void put(int key, int value) {
        if(map.contains(key)){
            remove(map[key]);
            map.erase(key);
        }else if(map.size() == limit){
            map.erase(tail->prev->key);
            remove(tail->prev);
        }

        DoublyListList* newNode = new DoublyListList(key,value);
            addNode(newNode);
            map[key] = newNode;
    }
        
    
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */