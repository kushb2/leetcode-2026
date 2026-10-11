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
    public ListNode findMid(ListNode head){ // 1 2 3 4
        // 1 2 3 4 5
        // 1 1 => 2 3 => 3 , 5 
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null; // spliting two list 
        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null, next = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        boolean turn = true;
        while(l1 != null || l2 != null){
            if(turn && l1 != null){
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            }
            
            if(!turn && l2 != null){
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            }

            
            turn = !turn;

        }

    }

    public void reorderList(ListNode head) {
        if(head.next == null) return;

        // find mid 
        ListNode l1 = head;
        ListNode l2 = findMid(head);
        l2 = reverse(l2);

        merge(l1, l2);
    }
}