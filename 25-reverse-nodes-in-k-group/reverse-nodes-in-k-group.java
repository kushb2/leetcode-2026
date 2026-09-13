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
    public int getCount(ListNode head){
        int k = 0;
        while(head != null){
            k++;
            head = head.next;
        } 
        return k;
    }
    public ListNode[] reverse(ListNode head, int k){
        ListNode prev = null;
        ListNode next = null;
        ListNode newTail = head; // head become new tail
        while (head != null && k > 0) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            k--;
        }
        newTail.next = next;
        return new ListNode[] { prev, newTail };
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode currHead = dummy;
        while(head != null){
            int count = getCount(head);
            if(count < k) break;

            ListNode[] res = reverse(head, k);
            ListNode newHead = res[0]; //2 
            ListNode newTail = res[1]; // 1
            if(newTail == null) break;

            currHead.next = newHead; //dummy => 2
            currHead = newTail; // 1
            head = newTail.next;// 3 
            
        }
        return dummy.next;
        
    }
}