class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);        
    }
    public int dfs(TreeNode root, int sum){
        if(root==null){
            return 0;
        }
        sum = sum*10+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }
        return dfs(root.left, sum)+dfs(root.right, sum);
    }  
}
//Time c. O(n) and space O(H) (ie.O(n) in worst case and O(log(n) in avg case) 
