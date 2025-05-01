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
