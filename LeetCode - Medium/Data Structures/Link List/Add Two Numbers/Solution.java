/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry =0;
        ListNode x = l1,y=l2;
        ListNode current,dummy;
        dummy = new ListNode();
        current = dummy;
        
        while(x!=null || y!= null)
        {
            int a = (x!=null) ? x.val : 0;
            int b = (y!=null) ? y.val : 0;
            
            int sum = a+b+carry;
            carry = sum/10;
            
            current.next = new ListNode(sum%10);
            
            if(x!=null){x=x.next;}
            if(y!=null){y=y.next;}
            
            current = current.next;
        }
        if(carry!=0)
        {
            current.next = new ListNode(carry);
        }
        return dummy.next;
        
        /*
        for(;x!=null&&y!=null;x=x.next,y=y.next)
        {
            int z = x.val + y.val;
            if(z<10)
            {
                if(ans == null)
                {
                    ans = new ListNode(z+carry);
                    carry=0;
                    current = ans;
                }
                else
                {
                    current.next = new ListNode(z+carry);
                    carry = 0;
                    current = current.next;
                }
            }
            else
            {
                 if(ans == null)
                {
                    ans = new ListNode(z%10+carry);
                    carry = z/10; 
                    current = ans;
                }
                else
                {
                    current.next = new ListNode(z%10+carry);
                    carry= z/10;
                    current = current.next;
                }  
            }
        }
        while(x!=null)
        {
             if(ans == null)
                {
                    ans = new ListNode(x.val+carry);
                    carry=0;
                    current = ans;
                }
                else
                {
                    current.next = new ListNode(x.val+carry);
                    carry=0;
                    current = current.next;
                }  
        }
         while(y!=null)
        {
             if(ans == null)
                {
                    ans = new ListNode(y.val+carry);
                    carry=0;
                    current = ans;
                }
                else
                {
                    current.next = new ListNode(y.val+carry);
                    carry=0;
                    current = current.next;
                }  
        }
        if(carry!=0)
        {
             current.next = new ListNode(carry);
              carry=0;
             current = current.next;
        }
        return ans;  */
    }
}
