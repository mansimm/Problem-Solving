//Solution2: with less runtime than solution1
class Solution2 {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        String[] stack = new String[arr.length];
        int top = -1;

        for(String s: arr){
            if(s.isEmpty()||s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(top!=-1){
                    top--;
                }
            }else{
                stack[++top] = s;
            }
        }
        if(top==-1){
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<=top;i++){
            result.append("/").append(stack[i]);
        }
        return result.toString();
    }
}
//Time O(n) and Space O(n)
