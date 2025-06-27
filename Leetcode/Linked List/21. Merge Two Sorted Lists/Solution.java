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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                current.next = list1;
                list1=list1.next;
            }else{
                current.next = list2;
                list2=list2.next;
            }
            current = current.next;
        }
        if(list1!=null){
            current.next=list1;
        }
        if(list2!=null){
            current.next=list2;
        }
        return dummy.next;
    }
}
/*
Time c = O(m+n) , space c = O(1)
This is an optimal two-pointer merge algorithm that efficiently combines two sorted linked lists by:
  1.Comparing values at current positions
  2.Advancing the pointer with the smaller value
  3.Linking remaining nodes when one list is exhausted
The solution is both time and space efficient for the merge two sorted lists problem.
Common technique to solve linked list problems –
  1.	create a dummy node with 0 value, whose next will be head of our result list
  2.	another pointer current, initially points to dummy, with each added node it will move forward and always points to last node of list
  3.	return dummy.next which is head of our list 
  */
