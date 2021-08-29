/*
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        String sub = "";
        int max = 0;
        
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                if(sub.isEmpty())
                {
                    sub += s.charAt(j);
                }
                else if(!sub.contains(s.charAt(j)+""))
                {
                    sub += s.charAt(j);
                }
                else
                {
                    break;
                }
            }
            if(sub.length()>max)
            {
                max = sub.length();
            }
            sub = "";
        }
        return max;
    }
}
