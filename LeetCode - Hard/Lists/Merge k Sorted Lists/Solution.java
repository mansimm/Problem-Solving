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
        
        ListNode head=null,tail=null;
        if(lists==null)
        {
          return head;   
        }
        
        int x=0;//to store index of  lowest head valued list
       
        int low = 1000;
        
        while(checkNull(lists))
        {
            low = 1000;
            for(int i=0;i<lists.length;i++)
            {
                if(lists[i]!=null && lists[i].val<=low)
                {
                    x = i;
                    low = lists[i].val;
                    //System.out.println("low: "+low);
                }
            }
            //System.out.println("lists[x]: "+lists[x].val);
            if(head==null)
            {
                head=tail=lists[x];
                lists[x]=lists[x].next;
            }
            else
            {
                tail.next = lists[x];
                tail = tail.next;
                lists[x]=lists[x].next;
            }
        }
        return head;
    }
    public boolean checkNull(ListNode[] lists)
    {
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            {
                return true;
            }
        }
        return false;
    }
}
