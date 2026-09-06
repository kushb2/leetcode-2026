/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
       
        // first create a map old to new node 
        // second iterration old list 
        // old to old random pointer
        // new to new random pointer 
        unordered_map<Node*, Node*> oldToNew;
        Node* curr = head;
        Node* dummy = new Node(-1);
        while(curr != nullptr){
            Node* newCurr = new Node(curr->val);
            oldToNew[curr] = newCurr;
            curr = curr->next;
            dummy->next = newCurr;
            dummy = dummy->next;
        }

        curr = head;
        while(curr != nullptr){
            Node* newCurr = oldToNew[curr];
            Node* oldRandom = curr->random;
            Node* newRandom = oldToNew[oldRandom];

            newCurr->random = newRandom;
            curr = curr->next;

        }
        return oldToNew[head];

    }
};