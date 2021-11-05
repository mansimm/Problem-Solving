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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int len=0;
        while(p!=null)
        {
            len++;
            p=p.next;
        }
        p=head;
        int i=1;
        if(len==1&&n==1)
        {
            return null;
        }
        while(p!=null && i!=len-n)//5-2=3
        {
            i++;
            p=p.next;
        }
        if(p==null)
        {
            return head.next;
        }
        else if(p.next==null)
        {
            return null;
        }
        p.next = p.next.next;
        return head;
            
    }
}
