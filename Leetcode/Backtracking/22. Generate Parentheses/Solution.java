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
/*
Time Complexity: O(Number of Valid Combinations)
Simple Version:
How many valid combinations? This follows Catalan numbers
Catalan numbers grow like: 1, 2, 5, 14, 42, 132...
For n pairs: approximately 4^n ÷ √n combinations
Examples:
n=1: 1 combination
n=2: 2 combinations 
n=3: 5 combinations
n=4: 14 combinations
Time = (Number of combinations) × (Length of each string) Time = Catalan(n) × 2n

Space Complexity: O(n)
Simple Version:
Stack space: At most 2n recursive calls deep
String building: At most 2n characters in path
Total extra space: O(n)
Note: The final answer takes O(Catalan(n) × n) space, but that's just storing the results.
Why This is Efficient:
Smart Pruning:
Don't add ')' if it would make string invalid
Don't add '(' if you've used all opening brackets
This eliminates lots of bad paths early!

*/
