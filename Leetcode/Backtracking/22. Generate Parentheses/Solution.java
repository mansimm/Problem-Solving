class Solution {
    List<String> ans = new ArrayList();
    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder());
        return ans;
    }
    public void backtrack(int l, int r, StringBuilder path){
        if(l==0 && r==0){
            ans.add(path.toString());
            return;
        }
        if(l>0){
            path.append("(");
            backtrack(l-1, r, path);
            path.deleteCharAt(path.length()-1);
        }
        if(l<r){
            path.append(")");
            backtrack(l, r-1, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
