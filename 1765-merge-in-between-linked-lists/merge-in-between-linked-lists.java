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
    public ListNode getTrail(ListNode head){
        while(head.next != null) head = head.next;
        return head;
    }
    public ListNode[] getStartAndEndNode(ListNode head, int a, int b){
               // Input: list1 = [-1 10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
            // Output: [10,1,13,1000000,1000001,1000002,5]

        ListNode start = null, end = null;
        while(head != null){
            if(a == 0){ // b=4(10),b=3(1),b=2(13),b=1(6),b=0(9)
                start = head;
            }
            if(b == -2){
                end = head;
                break;
            }
            a--; b--;
            head = head.next;
        }
        return new ListNode[] { start, end };
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;

        ListNode[] ends = getStartAndEndNode(dummy, a, b);
        ListNode start = ends[0], end = ends[1];
        start.next = list2; 
        ListNode tailListb = getTrail(list2);
        tailListb.next = end;

        // start point => move head to 3rd node 
        // end point => move head to 4rd node 
        // start point -> new list -> end point 
        return dummy.next; 

    }
}
