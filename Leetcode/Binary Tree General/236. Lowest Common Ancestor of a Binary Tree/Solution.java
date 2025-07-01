class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val==p.val || root.val==q.val){
            return root;
        }
        if(root.left==null && root.right==null){
            return null;
        }
        TreeNode left = null;
        TreeNode right = null;
        if(root.left!=null){
            left = lowestCommonAncestor(root.left, p, q);
        }
        if(root.right!=null){
            right = lowestCommonAncestor(root.right, p, q);
        }
        if(left!=null && right!=null){
            return root;
        }
        return left==null?right:left;
    }
}
/*
Complexity Analysis
Time Complexity: O(n)
Worst case: Visit all nodes in the tree
Each node processed once: Constant work per node
No early termination: Must explore both subtrees to be certain
Space Complexity: O(h)
Recursive call stack: Proportional to tree height
Best case: O(log n) for balanced tree
Worst case: O(n) for skewed tree
  */
