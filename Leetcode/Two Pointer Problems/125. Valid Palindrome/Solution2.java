class Solution2 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            else if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }else{
                i++;j--;
            }
        }
        return true;
    }
}
//The time complexity is O(n), where n  is the length of the string. The space complexity is O(1)
