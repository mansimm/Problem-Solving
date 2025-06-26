//Hint: use slow and fast pointers
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode temp1 = head;
        ListNode temp2 = temp1.next;
        while(temp1!=null && temp2!=null && temp2.next!=null){
            if(temp1==temp2){
                return true;
            }
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        return false;
    }
}
//Time c = O(n) , space c = O(1)
