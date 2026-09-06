/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    struct Compare{
        static bool operator()(const ListNode* a, const ListNode *b){
            return a->val > b->val;
        }
    };
    

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size() == 0) return nullptr;
        if(lists.size() == 1) return lists[0];
        ListNode* l3 = new ListNode(0);
        ListNode* head = l3;

        priority_queue<ListNode*, vector<ListNode*>, Compare> q;

        for(auto it: lists){
            if(it != nullptr) q.push(it);
        }

        while(!q.empty()){
            ListNode* smallest = q.top(); q.pop();
            l3->next = smallest;
            l3 = l3->next;
            if(smallest->next != nullptr) q.push(smallest->next);
        }

        return head->next;

    }
};