class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;
        
        for(ListNode current = head;current!=null;current = current.next){
            if(current.val>=x){
                after.next = current;
                after = current;
            }else{
                before.next = current;
                before = current;
            }
        }
        before.next = afterHead.next;
        after.next = null;
        return beforeHead.next;
    }
}
//Time c O(n) , space O(1)
