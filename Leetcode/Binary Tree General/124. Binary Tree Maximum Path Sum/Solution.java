class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        currentMaxPathSum(root);
        return ans;
    }
    public int currentMaxPathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(currentMaxPathSum(root.left), 0);//0 bcoz we don’t want negative sum
        int right = Math.max(currentMaxPathSum(root.right), 0);
        ans = Math.max(ans, root.val+left+right);
        return root.val + Math.max(left, right);
    }
}
/*
Time c. O(n) and space O(H) (ie.O(n) in worst case and O(log(n)) in avg case 
Core Logic: currentMaxPathSum(TreeNode root)
Returns the maximum sum of a path that starts from the current node and goes down
Updates the global maximum considering paths that pass through the current node
1.Two Types of Paths Considered:
Through-node paths: root.val + left + right (can't be extended upward)
From-node paths: root.val + max(left, right) (can be extended upward)
2.Negative Handling: Math.max(..., 0) ensures we don't include negative subtree contributions
3.Global Tracking: ans captures the best "through-node" path at each level

*/
