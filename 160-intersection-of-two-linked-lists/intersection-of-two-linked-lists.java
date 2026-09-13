/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int length(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = length(headA);
        int l2 = length(headB);

        if(l1 < l2){
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        int k = Math.abs(l1-l2);
        while(k>0){
            headA = headA.next;
            k--;
        }

        while(headA != null && headB != null){
            if(headA.equals(headB)) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
        
    }
}