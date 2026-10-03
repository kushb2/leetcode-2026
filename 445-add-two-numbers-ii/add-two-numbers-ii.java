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
        ListNode prev = null, next = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode sum(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            l3.next = new ListNode(sum % 10);
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            l3 = l3.next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // reverse 
        // l1 = [7,2,4,3], l2 = [5,6,4]
        // l1 = [3,4,2,7], l2 = [4,6,5]
        l1 = reverse(l1);
        l2 = reverse(l2);

        // sum 
        // l3 = 7087 
        ListNode l3 = sum(l1, l2);

        // reverse 
        // l3 = 7807
        l3 = reverse(l3);

        return l3;

        
    }
}