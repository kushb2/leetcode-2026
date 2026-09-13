/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode l3 = dummy;
        while(l1 != null || l2 != null){
            int a = l1 != null ? l1.val : Integer.MAX_VALUE;
            int b = l2 != null ? l2.val : Integer.MAX_VALUE;

            if(a < b){
                l3.next = l1;
                l1 = l1 != null ? l1.next : null;
            }else{
                l3.next = l2;
                l2 = l2 != null ? l2.next : null;
            }
            
            l3 = l3.next;
        }
        return dummy.next;

    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode l3 = null;
        for(ListNode it: lists){
            l3 = merge(l3, it);
        }
        return l3;
        
    }
}