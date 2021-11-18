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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
        {
            return head;
        }
        if(k==0)
        {
            return head;
        }
        ListNode p = head;
        int len = 0;
        while(p!=null)
        {
            len++;
            p = p.next;
        }
        int rotations = k%len;
        if(k>len)
        {
            k = rotations;
        }
        while(k!=0)
        {
            p = head;
            while(p.next.next != null)
            {
                p = p.next;
            }
            p.next.next = head;
            head = p.next;
            p.next = null;
            k--;
        }
        return head;
    }
}
