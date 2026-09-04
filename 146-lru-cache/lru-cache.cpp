class LRUCache {
public:

    class DoublyLinkList{
        public:
        int key, vale;
        DoublyLinkList *prev, *next;

        DoublyLinkList(int k, int v){
            key = k, vale = v;
            prev = next = nullptr;
        }
    };

    int limit;
    DoublyLinkList* head = new DoublyLinkList(-1,-1);
    DoublyLinkList* tail = new DoublyLinkList(-1,-1);
    unordered_map<int,DoublyLinkList*> map;

    void addNode(DoublyLinkList* newNode){
        // prev/head  newNode  next 
        DoublyLinkList* prev = head;
        DoublyLinkList* next = head->next;

        prev->next = newNode;
        newNode->prev = prev;
        newNode->next = next;
        next->prev = newNode;

    }

    void removeNode(DoublyLinkList * node){
        // prev nodeForDeletion next
        DoublyLinkList* prev = node->prev;
        DoublyLinkList* next = node->next;

        prev->next = next;
        next->prev = prev;
    }
     // head -> tail
    LRUCache(int capacity) {
        limit = capacity;
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        if(map.contains(key) == false) return -1;
        int ans = map[key]->vale;
        removeNode(map[key]);
        map.erase(key);

        DoublyLinkList *newNode = new DoublyLinkList(key,ans);
        addNode(newNode);
        map[key]= newNode;

        return ans;
        
    }
    
    void put(int key, int value) {
        if(map.contains(key)){
            removeNode(map[key]);
            map.erase(key);
        }else if(map.size() == limit){
            map.erase(tail->prev->key);
            removeNode(tail->prev);
        }

        DoublyLinkList *newNode = new DoublyLinkList(key,value);
        addNode(newNode);
        map[key]= newNode;
        
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */