//Hint: with each stack element we are storing min element till that element as top
//We will create stack with elements as array(pairs), in each pair first element is actual value and second element is min value till this element from stack
class MinStack {
    Stack<int[]> stack = new Stack();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val});
        }else{
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//Time c O(1) and space c O(n)
