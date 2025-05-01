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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = split(head);
        ListNode h1 = head;
        ListNode h2 = mid.next;
        mid.next = null;

        return merge(sortList(h1), sortList(h2));
    }
    public ListNode split(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                res.next = h1;
                h1 = h1.next;
            }else{
                res.next = h2;
                h2 = h2.next;
            }
            res = res.next;
        }
        if(h1!=null){
            res.next = h1;
        }
        if(h2!=null){
            res.next = h2;
        }
        return dummy.next;
    }
}
//Time complexity = O(nlogn), space complexity O(logn) 
