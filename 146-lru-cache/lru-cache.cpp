

class LRUCache {
public:
    class Node {
    public:
        int key, value;
        Node *prev, *next;

        Node(int k, int v){
            key = k;
            value = v;
            prev = next = NULL;
        }
    };

    void addNode(Node* newNode){
        // prev   newNode    next
        Node* prev = head;
        Node* next = head->next;

        prev->next = newNode;

        newNode->prev = prev;
        newNode->next = next;

        next->prev = newNode;

    }

    int limt = 0;
    Node* head = new Node(-1,-1);
    Node* tail = new Node(-1,-1);

    unordered_map<int, Node*> map;

    void remove(Node* existingNode){
        // prev existingNode next
        Node* prev = existingNode->prev;
        Node* next = existingNode->next;
        prev->next = next;
        next->prev = prev;
    }
    
    LRUCache(int capacity) {
        limt = capacity;
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        if(map.contains(key) == false) return -1;

        Node* existingNode = map[key];
        int ans = existingNode->value;

        remove(existingNode);
        map.erase(key);

        Node* newNode = new Node(key, ans);
        addNode(newNode);
        map[key] = newNode;

        return ans;
        
    }
    
    void put(int key, int value) {
        if(map.contains(key)){
            remove(map[key]);
             map.erase(key);
        }
        if(map.size() == limt){
            map.erase(tail->prev->key);
            remove(tail->prev);
        }

        Node* newNode = new Node(key,value);
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