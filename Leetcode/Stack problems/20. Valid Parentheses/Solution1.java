class Solution1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char prev = ' ';
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
//Time O(n), space O(n)
