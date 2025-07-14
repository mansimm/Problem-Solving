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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length == 0){
            return null;
        }
        List<ListNode> head = Arrays.asList(lists);
        while(head.size()>1){
            List<ListNode> merged = new ArrayList();
            for(int i=0;i<head.size();i=i+2){
                ListNode h1 = head.get(i);
                ListNode h2 = (i+1)<head.size()?head.get(i+1):null;
                merged.add(merge(h1, h2));
            }
            head = merged;
        }
        return head.get(0);
    }
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(h1!=null || h2!=null){
            if(h2==null || (h1!=null && h1.val<h2.val)){
                res.next = h1;
                h1 = h1.next;
            }else{
                res.next = h2;
                h2 = h2.next;
            }
            res = res.next;
        }
        return dummy.next;
    }
}
/*
Time Complexity Analysis
Overall Time Complexity: O(N log k)
Where:
N = total number of nodes across all k lists
k = number of linked lists
Breakdown:
1.Number of merge rounds: The algorithm uses a divide-and-conquer approach, pairing lists and merging them. In each round, the number of lists is halved, so there are log k rounds.
2.Work per round: In each round, every node is processed exactly once during the merging operations. Since there are N total nodes, each round takes O(N) time.
3.Total: O(N) × O(log k) = O(N log k)
Space Complexity Analysis
Overall Space Complexity: O(k)
Breakdown:
1.Auxiliary space for list management: 
Arrays.asList(lists) creates a list wrapper: O(1)
merged ArrayList in each iteration: O(k/2^i) where i is the round number
Maximum space used is O(k) in the first iteration
2.Recursive call stack: The merge function is iterative, not recursive, so no additional stack space.
3.Output space: The merged result reuses existing nodes, so no additional space for the output structure.

*/
