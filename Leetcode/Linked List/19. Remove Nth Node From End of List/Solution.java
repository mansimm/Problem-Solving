class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        int len = getLength(head);
        int k = len - n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        for(int i=0;i<k;i++){
            current = current.next;
            prev = prev.next;
        }
        prev.next = current.next;
        return dummy.next;
    }
    public int getLength(ListNode head){
        int count = 0;
        for(ListNode temp=head;temp!=null;temp=temp.next){
            count++;
        }
        return count;
    }
}
//Time c = O(n), space c O(1)
