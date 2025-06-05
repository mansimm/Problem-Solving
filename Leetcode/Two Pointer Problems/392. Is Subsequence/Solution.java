/*
Steps:
1.	Take 2 pointer i=0 and j=0 to iterate on s and t5 respactively
2.	Compare char at I and j, if thet are equal i++,j++
3.	Else only j++
  */
 class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        if(i==s.length()){
            return true;
        }else{
            return false;
        }
    }
}
// Time complexity: O(t) where t is bigger string in which needs to check substring
// Space Complexity: O(1)
