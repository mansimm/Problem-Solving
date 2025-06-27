/*
Var info:
leftPre = node points to node before left
sublistNode = first node of sublist ie. left, after reverse it will be right
currentNode = points to current node
preNode = pointes to node before current
Steps:
1.	move till currentNode pointing to left and LeftPre to node before current
2.	store left pointer in sublistNode
3.	now move until right+1, in this loop maintain 3 pointers nextNode, currentNode and preNode to point next, current and prev pointers respectively
4.	move pointers to reverse list 
5.	now set leftPre.next= preNode, sublistNode.next = currentNode
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currentNode = head;
        ListNode leftPre = dummy;
        for(int i=0;i<left-1;i++){
            currentNode = currentNode.next;
            leftPre = leftPre.next;
        }
// now currentNode points to left, leftPre node before left
        ListNode subListNode = currentNode;
        ListNode preNode = null;
        for(int i=0;i<=right-left;i++){
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        leftPre.next=preNode;
        subListNode.next=currentNode;
        return dummy.next;
    }
}
//Time complexity O(n), space c. O(1)
//Note - dummy to maintain prev pointer, https://youtu.be/oDL8vuu2Q0E, use of the dummy does not requires adding any special conditions while we are at the start of linked list
