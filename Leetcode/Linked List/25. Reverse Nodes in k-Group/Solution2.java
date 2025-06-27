//Solution2 : simpler to understand
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        int len = getLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        for(int i=0;i<len/k;i++){
            for(int j=0;j<k-1;j++){
                ListNode next = current.next;
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = current;
            current = current.next;
        }
        return dummy.next;
    }
    public int getLength(ListNode head){
        int count = 0;
        for(ListNode temp=head; temp!=null;temp=temp.next){
            count++;
        }
        return count;
    }
}
//time c O(n) space O(n)
