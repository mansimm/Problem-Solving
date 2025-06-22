class Solution2 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Map<String, BiFunction<Integer,Integer,Integer>> op = Map.of("+", (a,b)->a+b, "-", (a,b)->a-b, "*", (a,b)->a*b, "/", (a,b)->a/b);
        for(String s: tokens){
            if(op.containsKey(s)){
                int b = stack.pop();//reversed the seq
                int a = stack.pop();//reversed the seq
                stack.push(op.get(s).apply(a,b));//reversed the seq
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
//Time c – O(n) space c - O(n), take 1 ms more that solution1 in runtime
