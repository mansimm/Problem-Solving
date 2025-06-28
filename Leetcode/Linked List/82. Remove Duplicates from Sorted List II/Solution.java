class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            if(next!=null && next.val==current.val){
                while(next!=null && next.val==current.val){
                    current = current.next;
                    next = next.next;
                }
                prev.next = next;
                current = prev.next;
            }else{
                current=current.next;
                prev = prev.next;
            }  
        }
        return dummy.next;
    }
}
//time c O(n) space O(1)
