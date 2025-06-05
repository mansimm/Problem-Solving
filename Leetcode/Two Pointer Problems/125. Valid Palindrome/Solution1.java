class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        String in = s.toLowerCase();
        int j = in.length()-1;
        while(i<j){
            while(i<in.length() && !Character.isLetterOrDigit(in.charAt(i))){
                i++;
            }
            while(j>=0 && !Character.isLetterOrDigit(in.charAt(j))){
                j--;
            }
            if(i<in.length() && j>=0 && in.charAt(i)!=in.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
/*
Time complexity – O(n), even with while in while we are iterating over String only once
Space complexity – The space complexity of this algorithm is O(n), where n is the length of the input string. Here's why:
1.String in = s.toLowerCase(): This operation creates a new string with all characters converted to lowercase. In the worst case (when all characters are uppercase), it will create a new string of the same length as the input string. This contributes O(n) to the space complexity.
2.Other variables (i, j) are just integer primitives and contribute O(1) constant space.
3.No additional data structures (like arrays, lists, or maps) are created within the method.
4.The method doesn't use recursion, so there's no additional space used on the call stack.
  */
