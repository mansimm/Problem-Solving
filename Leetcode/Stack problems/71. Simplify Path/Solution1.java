class Solution1 {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack();

        for(String s: arr){
            if(s.isEmpty() || s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
        return "/"+String.join("/", stack);
    }
}
//Time c O(n) and space c O(n)
