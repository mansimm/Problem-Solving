/*Steps:
1.	count node of list in count, if count<k return list as is
2.	create dummy node and dummy.next = head
3.	we need pointers temp, tempNext=points to temp.next, first=temp.next, second=first.next, next=second.next
4.	iterate while temp.next!=null, if current count<k return list
5.	initialize nodes = k-1, reverse node till node--!=0, after that assign temp.next=first, tempNext.next=second, count=count-k, , temp=temNext
6.	return dummy.next
  */
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        int count = 0;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        temp = dummy;
        while(temp.next!=null){
            if(count<k){
                break; //return list as is bcoz remaining list len is less than k
            }
            int nodes = k-1;
            ListNode tempNext = temp.next;//tail of reversed sublist
            ListNode first = temp.next;
            ListNode second = first.next;
            while(nodes-- > 0){
                ListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }
            
            temp.next=first;
            tempNext.next = second;
            count = count - k;
            temp = tempNext;
        }
        return dummy.next;
    }
}
// https://youtu.be/FYsYAELWyRs
// time c O(n) space O(1)
