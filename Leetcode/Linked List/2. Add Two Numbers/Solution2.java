class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while(l1!=null || l2!=null || carry>0){
//carry>0 this condition makes sure that last carry>0 will also be added in list
            if(l1!=null){
                carry += l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                carry += l2.val;
                l2=l2.next;
            }
            ListNode node = new ListNode(carry%10);
            carry = carry/10;
            current.next = node;
            current = current.next;
        }
        return head.next;
    }
}
//Less lines of code
//Time c. = O(max(m,n)), space O(1) where m,n are length of list l1 and l2 respectively
