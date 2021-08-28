/*
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
*/

class Solution {
    public boolean isPalindrome(int x) {
     
        String num = x+"";
        for(int i=0,j=num.length()-1;i<num.length()&&j>=0;i++,j--)
        {
            if(num.charAt(i)!=num.charAt(j))
            {
                return false;
            }
        }
        return true;
    }
}
