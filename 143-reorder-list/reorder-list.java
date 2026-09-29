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
    public ListNode reverse(ListNode head){
        ListNode prev = null, next;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public ListNode[] mid(ListNode head) {
        ListNode slow = head, fast = head, prev = null, originalHead = head;
        while(fast != null && fast.next != null){
            prev = slow;// 1
            slow = slow.next;//2
            fast = fast.next.next;// 3
        }
        prev.next = null;
        return new  ListNode[] { originalHead, slow }; // 1 2 3 4 5
    }

 
   
    public void merge(ListNode l1, ListNode l2){
        boolean chance = true;
        ListNode l3 = new ListNode(-1);
        while(l1 != null && l2 != null){// 12 34 
            if(chance){
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
                chance = false;
            }else{
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
                chance = true;
            }
        
        }
        l3.next = l2;
    }

    public void reorderList(ListNode head) {
        if(head.next == null) return;

        ListNode[] split = mid(head);
        ListNode list1 = split[0];
        ListNode list2 = split[1];

        list2 = reverse(list2);

        merge(list1, list2);
        
    }
}