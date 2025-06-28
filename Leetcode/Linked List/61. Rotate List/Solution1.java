class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null){
            return head;
        }
        int len = getLength(head);
        k = k%len;
        if(len==1||k==0){
            return head;
        }
        ListNode current = head;
        for(int i=1;i<len-k;i++){
            current=current.next;
        }
        ListNode next = current.next;
        current.next = null;
        ListNode temp = next;
        while(temp!=null && temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        head=next;
        return head;
    }

    public int getLength(ListNode head){
        int count = 0;
        for(ListNode temp=head; temp!=null; temp=temp.next){
            count++;
        }
        return count;
    }
}
//Time c O(n) , space O(1)
