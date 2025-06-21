class Solution2 {
    public boolean isValid(String s) {
        if(s.length()%2 != 0){
            return false;
        }
        int[] stack = new int[s.length()];
        int top = -1;
        for(char c: s.toCharArray()){
            if(c=='{' || c=='('||c=='['){
                stack[++top] = c;
            }else if(top==-1 || 
            (c==')' && stack[top]!='(') ||
            (c==']' && stack[top]!='[') || 
            (c=='}' && stack[top]!='{')){
                return false;
            }else{//matching bracket found
                top--;
            }
        }
        return top == -1;
    }
}
/*
This solution has a time complexity of O(n) where n is the length of the string, and a space complexity of O(n) 
in the worst case (when all characters are opening brackets). However, it uses less memory than the original 
solution due to using a primitive char array instead of a Deque of Character objects.
  */
