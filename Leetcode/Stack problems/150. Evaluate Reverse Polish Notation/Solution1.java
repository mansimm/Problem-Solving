class Solution1 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String s: tokens){
            if(s.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);//reverse order of a,b on operations
            }else if(s.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b+a);//reverse order of a,b on operations
            }else if(s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);//reverse order of a,b on operations
            }else if(s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);//reverse order of a,b on operations
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
//Time c. O(n) space c O(n)
