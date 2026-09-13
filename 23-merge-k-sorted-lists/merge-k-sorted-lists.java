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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(
            (l1,l2) -> Integer.compare(l1.val , l2.val));

            for(ListNode l1: lists){
                if(l1 != null){
                    q.offer(l1);
                }
            }

            ListNode dummy = new ListNode();
            ListNode l3 = dummy;

            while(!q.isEmpty()){
                ListNode curr = q.poll();
                l3.next = curr;
                l3 = l3.next;
                if(curr.next != null){
                    q.offer(curr.next);
                }
            }

        
        return dummy.next;
    }
}