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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* curr = new ListNode(0);
        ListNode* list3 = curr;
        while(list1 != NULL || list2 != NULL) {
            int x = list1 != NULL ? list1->val : INT_MAX;
            int y = list2 != NULL ? list2->val : INT_MAX;

            if(x < y) {
                list3->next = list1;
                list1 = list1 != NULL ? list1->next : NULL;
                
            }else{
                list3->next = list2;
                list2 = list2 != NULL ? list2->next : NULL;
            }
            
            list3 = list3->next;

        }
        return curr->next;
        
    }

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size() == 0) return nullptr;
        if(lists.size() == 1) return lists[0];

        ListNode* l1 = lists[0];
        for(int i=1;i<lists.size();i++){
            ListNode* l2 = lists[i];
            l1 = mergeTwoLists(l1,l2);
        }

        return l1;
        
    }
};