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
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode head = null;

        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val;
            sum += rem;
            if(sum>9){
                rem = sum/10;
                sum = sum%10;
            }else{
                rem =0;
            }
            head = insert(sum, head);
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum = l1.val;
            sum += rem;
            if(sum>9){
                rem = sum/10;
                sum = sum%10;
            }else{
                rem =0;
            }
            head = insert(sum, head);
            l1=l1.next;
        }
        while(l2!=null){
            int sum = l2.val;
            sum += rem;
            if(sum>9){
                rem = sum/10;
                sum = sum%10;
            }else{
                rem =0;
            }
            head = insert(sum, head);
            l2=l2.next;
        }
        if(rem!=0){
            head = insert(rem, head);
        }
        return head;
    }
    public ListNode insert(int val, ListNode head){
        ListNode newNode = new ListNode();
            newNode.val = val;
            if(head==null){
                head = newNode;
            }else{
                ListNode temp = head;
                while(temp.next!=null){
                    temp= temp.next;
                }
                temp.next = newNode;
            }
            return head;
    }
}
//Time c. = O(max(m,n)), space O(1) where m,n are length of list l1 and l2 respectively
