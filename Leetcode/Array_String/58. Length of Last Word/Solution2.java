class Solution2 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        int i = s.length()-1;
        int len = 0;
        while(i>=0 && s.charAt(i)==' '){
            // traverse till non empty char
            i--;
        }
        while(i>=0 && s.charAt(i)!=' '){
            i--;
            len++;
        }
        return len;
    }
}
/*
1.Time Complexity: O(n), where n is the length of the string. In the worst case, we might need to traverse the entire string once.
2.Space Complexity: O(1), as we only use a constant amount of extra space regardless of the input size.
*/
